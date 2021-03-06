/*
 * Copyright (c) Numerical Method Inc.
 * http://www.numericalmethod.com/
 * 
 * THIS SOFTWARE IS LICENSED, NOT SOLD.
 * 
 * YOU MAY USE THIS SOFTWARE ONLY AS DESCRIBED IN THE LICENSE.
 * IF YOU ARE NOT AWARE OF AND/OR DO NOT AGREE TO THE TERMS OF THE LICENSE,
 * DO NOT USE THIS SOFTWARE.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITH NO WARRANTY WHATSOEVER,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION,
 * ANY WARRANTIES OF ACCURACY, ACCESSIBILITY, COMPLETENESS,
 * FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, NON-INFRINGEMENT,
 * TITLE AND USEFULNESS.
 * 
 * IN NO EVENT AND UNDER NO LEGAL THEORY,
 * WHETHER IN ACTION, CONTRACT, NEGLIGENCE, TORT, OR OTHERWISE,
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIMS, DAMAGES OR OTHER LIABILITIES,
 * ARISING AS A RESULT OF USING OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.numericalmethod.suanshu.stats.random.univariate.normal;

import com.numericalmethod.suanshu.stats.descriptive.moment.Kurtosis;
import com.numericalmethod.suanshu.stats.descriptive.moment.Mean;
import com.numericalmethod.suanshu.stats.descriptive.moment.Skewness;
import com.numericalmethod.suanshu.stats.descriptive.moment.Variance;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haksun Li
 */
public class StandardNormalRngTest {

    @Test
    public void test_0010() {
        Mean mean = new Mean();
        Variance var = new Variance();
        Skewness skew = new Skewness();
        Kurtosis kurtosis = new Kurtosis();

        StandardNormalRng rng = new StandardNormalRng();
        for (int i = 1; i <= 1000000; ++i) {
            double x = rng.nextDouble();

            mean.addData(x);
            var.addData(x);
            skew.addData(x);
            kurtosis.addData(x);
        }

        assertEquals(new com.numericalmethod.suanshu.stats.distribution.univariate.NormalDistribution().mean(),
                mean.value(), 0.01);
        assertEquals(new com.numericalmethod.suanshu.stats.distribution.univariate.NormalDistribution().variance(),
                var.value(), 0.01);
        assertEquals(new com.numericalmethod.suanshu.stats.distribution.univariate.NormalDistribution().skew(),
                skew.value(), 0.01);
        assertEquals(new com.numericalmethod.suanshu.stats.distribution.univariate.NormalDistribution().kurtosis(),
                kurtosis.value(), 0.05);
    }
}
