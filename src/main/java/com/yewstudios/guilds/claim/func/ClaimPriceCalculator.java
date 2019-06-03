package com.yewstudios.guilds.claim.func;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.guild.Guild;
import com.yewstudios.guilds.io.XFile;

/**
 * Created by Mat
 *
 * The calculator in order to figure out
 * how much a claim should cost based upon an exponential
 * curve and also the quantity of land already owned etc.
 */
public final class ClaimPriceCalculator {

    private Guild guild;

    private double finalClaimPrice;

    public ClaimPriceCalculator(Guild claimingGuild)
    {
        this.guild = claimingGuild;
        beginCalculation();
    }

    private void beginCalculation()
    {
        XFile config = Guilds.getFileManager().getFile("config");

        final double basePrice = config.getDouble("guilds.priceclaim");

        double claimedLand = Double.parseDouble(guild.getGuildData().getClaimedChunks().size()+"");

        double linearCost = (  basePrice + (claimedLand * basePrice) );

        double exponent = 1.80; //the exponent value for the price to increase, 1.8 works with the given economy level.

        double finalCost = linearCost * Math.pow(claimedLand, exponent);

        this.finalClaimPrice = finalCost;
    }

    public double getClaimPrice()
    {
        return this.finalClaimPrice;
    }



}
