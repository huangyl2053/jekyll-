/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author n3336
 */
public class HokenryoDankaiHanteiTest {

    private static final FukaKonkyo fk = new FukaKonkyo();
    private static final SeigyoJoho sj = new SeigyoJoho();
    private static final HokenryoDankaiHanteiInput input = new HokenryoDankaiHanteiInput();
    private static final List<HokenryoDankai> dankai = new ArrayList<>();
    private static final HokenryoDankaiHantei dankaiHantei = new HokenryoDankaiHantei();

    public HokenryoDankaiHanteiTest() {
        sj.set基準年金収入1(new Decimal("800000"));
        sj.set基準年金収入2(new Decimal("1200000"));
        sj.set基準年金収入3(new Decimal("800000"));
        sj.set基準所得金額1(new Decimal("0"));
        sj.set基準所得金額2(new Decimal("3000000"));
        sj.set基準所得金額3(new Decimal("4000000"));
        sj.set基準所得金額4(new Decimal("5000000"));
        sj.set基準所得金額5(new Decimal("6000000"));
        sj.set基準所得金額6(new Decimal("7000000"));
        sj.set基準所得金額7(new Decimal("8000000"));
        sj.set基準所得金額8(new Decimal("9000000"));
        sj.set基準所得金額9(new Decimal("10000000"));
        sj.set基準所得金額10(new Decimal("11000000"));
        sj.set基準所得金額11(new Decimal("12000000"));
        sj.set基準所得金額12(new Decimal("13000000"));
        sj.set基準所得金額13(new Decimal("14000000"));
        sj.set基準所得金額14(new Decimal("15000000"));
        sj.set基準所得金額15(new Decimal("16000000"));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void 生活保護受給者の場合第1段階を返す() {

        fk.set賦課基準日(new RDate("20140402"));
        fk.set生保開始日(new RDate("20140401"));
        fk.set生保終了日(new RDate("20150401"));
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);

        fk.set本人課税区分(new RString("非課税"));

        fk.set世帯課税区分(new RString("非課税"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第1段階"));

    }

    @Test
    public void 本人非課税＿世帯非課税＿公的年金等収入８０万円以下の場合第2段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("非課税"));
        fk.set世帯課税区分(new RString("非課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("0"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第2段階"));

    }

    @Test
    public void 本人非課税_世帯非課税_公的年金等収入80万円よりおおきく120万円以下の場合は第3段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("非課税"));
        fk.set世帯課税区分(new RString("非課税"));
        fk.set公的年金収入(new Decimal("800000"));
        fk.set合計所得金額(new Decimal("200000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第3段階"));
    }

    @Test
    public void 本人非課税_世帯非課税_公的年金等収入120万円より大きい場合の場合は第4段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("非課税"));
        fk.set世帯課税区分(new RString("非課税"));
        fk.set公的年金収入(new Decimal("1200001"));
        fk.set合計所得金額(new Decimal("0"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第4段階"));
    }

    @Test
    public void 本人非課税_世帯課税_公的年金等収入80万円以下の場合は第5段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("非課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("800000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第5段階"));
    }

    @Test
    public void 本人非課税_世帯課税_公的年金等収入80万円より大きい場合は第6段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("非課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("800001"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第6段階"));
    }

    @Test
    public void 本人課税_合計所得金額が0円以上300万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("0"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第7段階"));
    }

    @Test
    public void 本人課税_合計所得金額が300万円以上400万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("3000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第8段階"));
    }

    @Test
    public void 本人課税_合計所得金額が400万円以上500万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("4000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第9段階"));
    }

    @Test
    public void 本人課税_合計所得金額が500万円以上600万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("5999999"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第10段階"));
    }

    @Test
    public void 本人課税_合計所得金額が600万円以上700万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("6000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第11段階"));
    }

    @Test
    public void 本人課税_合計所得金額が700万円以上800万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("7000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第12段階"));
    }

    @Test
    public void 本人課税_合計所得金額が800万円以上900万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("8000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第13段階"));
    }

    @Test
    public void 本人課税_合計所得金額が900万円以上1000万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("9000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第14段階"));
    }

    @Test
    public void 本人課税_合計所得金額が1000万円以上1100万円未満は第7段階を返す() {
        fk.set賦課基準日(new RDate("20140401"));
        fk.set生保開始日(null);
        fk.set生保終了日(null);
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("10000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);

        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第15段階"));
    }

    @Test
    public void 生活保護対象かどうか月ごとに判定_生活保護がすでに終了している場合() {
        fk.set賦課基準日(new RDate("20140601"));
        fk.set生保開始日(new RDate("20140401"));
        fk.set生保終了日(new RDate("20140501"));
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("10000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);
        assertThat(dankaiHantei.getHokenryodankai(input), not("システム第1段階"));
    }

    @Test
    public void 生活保護対象かどうか月ごとに判定_生活保護を受けている() {
        fk.set賦課基準日(new RDate("20140601"));
        fk.set生保開始日(new RDate("20140401"));
        fk.set生保終了日(new RDate("20140701"));
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("10000000"));
        input.set賦課年度(new RString("20140401"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);
        assertThat(dankaiHantei.getHokenryodankai(input), is("システム第1段階"));
    }    
 
    @Test
    public void 保険料段階を月ごとに取得する() {
        fk.set賦課基準日(new RDate("20140601"));
        fk.set生保開始日(new RDate("20140401"));
        fk.set生保終了日(new RDate("20140701"));
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("10000000"));
        input.set賦課年度(new RString("2014"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);
        
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140401"), is("システム第1段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140701"), is("システム第1段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140801"), is("システム第15段階"));
    }      
 
    @Test
    public void 保険料段階を月ごとに取得する_生活保護前年度に終了済み() {
        fk.set賦課基準日(new RDate("20140601"));
        fk.set生保開始日(new RDate("20140101"));
        fk.set生保終了日(new RDate("20140301"));
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("10000000"));
        input.set賦課年度(new RString("2014"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);
        
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140401"), is("システム第15段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140701"), is("システム第15段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140801"), is("システム第15段階"));
    }   
    
    @Test
    public void 保険料段階を月ごとに取得する_年度途中から開始＿継続中() {
        fk.set賦課基準日(new RDate("20141201"));
        fk.set生保開始日(new RDate("20140901"));
        fk.set生保終了日(new RDate("20141101"));
        fk.set老齢福祉終了日(null);
        fk.set老齢福祉開始日(null);
        fk.set本人課税区分(new RString("課税"));
        fk.set世帯課税区分(new RString("課税"));
        fk.set公的年金収入(new Decimal("0"));
        fk.set合計所得金額(new Decimal("10000000"));
        input.set賦課年度(new RString("2014"));
        input.set制御情報(sj);
        input.set賦課根拠(fk);
        
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140401"), is("システム第15段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20140901"), is("システム第1段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20141001"), is("システム第1段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20141101"), is("システム第1段階"));
        assertThat(dankaiHantei.getHokenryoDankaiList(input).get("20141201"), is("システム第15段階"));
    }    
}
