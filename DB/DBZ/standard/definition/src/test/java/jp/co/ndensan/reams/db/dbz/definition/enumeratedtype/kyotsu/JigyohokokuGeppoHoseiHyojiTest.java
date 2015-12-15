package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事業報告月報補正表示のテストクラスです。
 *
 * @author LDNS
 */
public class JigyohokokuGeppoHoseiHyojiTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JigyohokokuGeppoHoseiHyoji.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JigyohokokuGeppoHoseiHyoji.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_保険者_第１号被保険者数_第１号被保険者増減内訳を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("001")), is(JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳));
    }

    @Test
    public void 引数に002を指定した場合_toValueは_保険者_食費_居住費に係る負担限度額認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("002")), is(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括));
    }

    @Test
    public void 引数に003を指定した場合_toValueは_保険者_食費_居住費に係る負担限度額認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("003")), is(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分));
    }

    @Test
    public void 引数に004を指定した場合_toValueは_保険者_利用者負担減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("004")), is(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括));
    }

    @Test
    public void 引数に005を指定した場合_toValueは_保険者_利用者負担減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("005")), is(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分));
    }

    @Test
    public void 引数に006を指定した場合_toValueは_保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("006")), is(JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括));
    }

    @Test
    public void 引数に007を指定した場合_toValueは_保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("007")), is(JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分));
    }

    @Test
    public void 引数に008を指定した場合_toValueは_保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("008")), is(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者));
    }

    @Test
    public void 引数に009を指定した場合_toValueは_保険者_利用者負担第４段階食費_居住費の特例減額措置を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("009")), is(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置));
    }

    @Test
    public void 引数に010を指定した場合_toValueは_保険者_要介護_要支援_認定者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("010")), is(JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数));
    }

    @Test
    public void 引数に011を指定した場合_toValueは_保険者_現物分_居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("011")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に012を指定した場合_toValueは_保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("012")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に013を指定した場合_toValueは_保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("013")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に014を指定した場合_toValueは_保険者_現物分_地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("014")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に015を指定した場合_toValueは_保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("015")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に016を指定した場合_toValueは_保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("016")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に017を指定した場合_toValueは_保険者_現物分_施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("017")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数));
    }

    @Test
    public void 引数に018を指定した場合_toValueは_保険者_償還_審査年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("018")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数));
    }

    @Test
    public void 引数に019を指定した場合_toValueは_保険者_償還_決定年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("019")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数));
    }

    @Test
    public void 引数に020を指定した場合_toValueは_保険者__別紙_第１号被保険者のいる世帯を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("020")), is(JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯));
    }

    @Test
    public void 引数に021を指定した場合_toValueは_保険者_現物分_介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("021")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数));
    }

    @Test
    public void 引数に022を指定した場合_toValueは_保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("022")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に023を指定した場合_toValueは_保険者_現物分_介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("023")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に024を指定した場合_toValueは_保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("024")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に025を指定した場合_toValueは_保険者_償還_審査年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("025")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数));
    }

    @Test
    public void 引数に026を指定した場合_toValueは_保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("026")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に027を指定した場合_toValueは_保険者_償還_審査年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("027")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に028を指定した場合_toValueは_保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("028")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に029を指定した場合_toValueは_保険者_償還_決定年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("029")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数));
    }

    @Test
    public void 引数に030を指定した場合_toValueは_保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("030")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に031を指定した場合_toValueは_保険者_償還_決定年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("031")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に032を指定した場合_toValueは_保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("032")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に033を指定した場合_toValueは_保険者_現物分_特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("033")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に034を指定した場合_toValueは_保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("034")), is(JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に035を指定した場合_toValueは_保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("035")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に036を指定した場合_toValueは_保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("036")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に037を指定した場合_toValueは_保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("037")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に038を指定した場合_toValueは_保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("038")), is(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に039を指定した場合_toValueは_保険者_高額介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("039")), is(JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費));
    }

    @Test
    public void 引数に040を指定した場合_toValueは_保険者_高額医療合算介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("040")), is(JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費));
    }

    @Test
    public void 引数に101を指定した場合_toValueは_構成市町村_第１号被保険者数_第１号被保険者増減内訳を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("101")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳));
    }

    @Test
    public void 引数に102を指定した場合_toValueは_構成市町村_食費_居住費に係る負担限度額認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("102")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括));
    }

    @Test
    public void 引数に103を指定した場合_toValueは_構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("103")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分));
    }

    @Test
    public void 引数に104を指定した場合_toValueは_構成市町村_利用者負担減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("104")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括));
    }

    @Test
    public void 引数に105を指定した場合_toValueは_構成市町村_利用者負担減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("105")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分));
    }

    @Test
    public void 引数に106を指定した場合_toValueは_構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("106")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括));
    }

    @Test
    public void 引数に107を指定した場合_toValueは_構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("107")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分));
    }

    @Test
    public void 引数に108を指定した場合_toValueは_構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("108")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者));
    }

    @Test
    public void 引数に109を指定した場合_toValueは_構成市町村_利用者負担第４段階食費_居住費の特例減額措置を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("109")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置));
    }

    @Test
    public void 引数に110を指定した場合_toValueは_構成市町村_要介護_要支援_認定者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("110")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数));
    }

    @Test
    public void 引数に111を指定した場合_toValueは_構成市町村_現物分_居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("111")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に112を指定した場合_toValueは_構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("112")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に113を指定した場合_toValueは_構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("113")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に114を指定した場合_toValueは_構成市町村_現物分_地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("114")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に115を指定した場合_toValueは_構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("115")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に116を指定した場合_toValueは_構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("116")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に117を指定した場合_toValueは_構成市町村_現物分_施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("117")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数));
    }

    @Test
    public void 引数に118を指定した場合_toValueは_構成市町村_償還_審査年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("118")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数));
    }

    @Test
    public void 引数に119を指定した場合_toValueは_構成市町村_償還_決定年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("119")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数));
    }

    @Test
    public void 引数に120を指定した場合_toValueは_構成市町村__別紙_第１号被保険者のいる世帯を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("120")), is(JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯));
    }

    @Test
    public void 引数に121を指定した場合_toValueは_構成市町村_現物分_介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("121")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数));
    }

    @Test
    public void 引数に122を指定した場合_toValueは_構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("122")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に123を指定した場合_toValueは_構成市町村_現物分_介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("123")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に124を指定した場合_toValueは_構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("124")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に125を指定した場合_toValueは_構成市町村_償還_審査年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("125")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数));
    }

    @Test
    public void 引数に126を指定した場合_toValueは_構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("126")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に127を指定した場合_toValueは_構成市町村_償還_審査年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("127")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に128を指定した場合_toValueは_構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("128")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に129を指定した場合_toValueは_構成市町村_償還_決定年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("129")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数));
    }

    @Test
    public void 引数に130を指定した場合_toValueは_構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("130")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に131を指定した場合_toValueは_構成市町村_償還_決定年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("131")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に132を指定した場合_toValueは_構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("132")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に133を指定した場合_toValueは_構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("133")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に134を指定した場合_toValueは_構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("134")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に135を指定した場合_toValueは_構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("135")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に136を指定した場合_toValueは_構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("136")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に137を指定した場合_toValueは_構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("137")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に138を指定した場合_toValueは_構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("138")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に139を指定した場合_toValueは_構成市町村_高額介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("139")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費));
    }

    @Test
    public void 引数に140を指定した場合_toValueは_構成市町村_高額医療合算介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("140")), is(JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費));
    }

    @Test
    public void 引数に201を指定した場合_toValueは_旧市町村_第１号被保険者数_第１号被保険者増減内訳を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("201")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳));
    }

    @Test
    public void 引数に202を指定した場合_toValueは_旧市町村_食費_居住費に係る負担限度額認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("202")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括));
    }

    @Test
    public void 引数に203を指定した場合_toValueは_旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("203")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分));
    }

    @Test
    public void 引数に204を指定した場合_toValueは_旧市町村_利用者負担減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("204")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括));
    }

    @Test
    public void 引数に205を指定した場合_toValueは_旧市町村_利用者負担減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("205")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分));
    }

    @Test
    public void 引数に206を指定した場合_toValueは_旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("206")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括));
    }

    @Test
    public void 引数に207を指定した場合_toValueは_旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("207")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分));
    }

    @Test
    public void 引数に208を指定した場合_toValueは_旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("208")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者));
    }

    @Test
    public void 引数に209を指定した場合_toValueは_旧市町村_利用者負担第４段階食費_居住費の特例減額措置を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("209")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置));
    }

    @Test
    public void 引数に210を指定した場合_toValueは_旧市町村_要介護_要支援_認定者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("210")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数));
    }

    @Test
    public void 引数に211を指定した場合_toValueは_旧市町村_現物分_居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("211")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に212を指定した場合_toValueは_旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("212")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に213を指定した場合_toValueは_旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("213")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に214を指定した場合_toValueは_旧市町村_現物分_地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("214")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に215を指定した場合_toValueは_旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("215")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に216を指定した場合_toValueは_旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("216")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数));
    }

    @Test
    public void 引数に217を指定した場合_toValueは_旧市町村_現物分_施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("217")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数));
    }

    @Test
    public void 引数に218を指定した場合_toValueは_旧市町村_償還_審査年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("218")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数));
    }

    @Test
    public void 引数に219を指定した場合_toValueは_旧市町村_償還_決定年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("219")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数));
    }

    @Test
    public void 引数に220を指定した場合_toValueは_旧市町村__別紙_第１号被保険者のいる世帯を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("220")), is(JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯));
    }

    @Test
    public void 引数に221を指定した場合_toValueは_旧市町村_現物分_介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("221")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数));
    }

    @Test
    public void 引数に222を指定した場合_toValueは_旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("222")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に223を指定した場合_toValueは_旧市町村_現物分_介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("223")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に224を指定した場合_toValueは_旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("224")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に225を指定した場合_toValueは_旧市町村_償還_審査年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("225")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数));
    }

    @Test
    public void 引数に226を指定した場合_toValueは_旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("226")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に227を指定した場合_toValueは_旧市町村_償還_審査年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("227")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に228を指定した場合_toValueは_旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("228")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に229を指定した場合_toValueは_旧市町村_償還_決定年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("229")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数));
    }

    @Test
    public void 引数に230を指定した場合_toValueは_旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("230")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲));
    }

    @Test
    public void 引数に231を指定した場合_toValueは_旧市町村_償還_決定年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("231")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分));
    }

    @Test
    public void 引数に232を指定した場合_toValueは_旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("232")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分));
    }

    @Test
    public void 引数に233を指定した場合_toValueは_旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("233")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に234を指定した場合_toValueは_旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("234")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に235を指定した場合_toValueは_旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("235")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に236を指定した場合_toValueは_旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("236")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に237を指定した場合_toValueは_旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("237")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数));
    }

    @Test
    public void 引数に238を指定した場合_toValueは_旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("238")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分));
    }

    @Test
    public void 引数に239を指定した場合_toValueは_旧市町村_高額介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("239")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費));
    }

    @Test
    public void 引数に240を指定した場合_toValueは_旧市町村_高額医療合算介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.toValue(new RString("240")), is(JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費));
    }

    @Test
    public void 保険者_第１号被保険者数_第１号被保険者増減内訳を指定した場合_getコードは_001を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.getコード(), is(new RString("001")));
    }

    @Test
    public void 保険者_食費_居住費に係る負担限度額認定_総括を指定した場合_getコードは_002を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.getコード(), is(new RString("002")));
    }

    @Test
    public void 保険者_食費_居住費に係る負担限度額認定_再掲_第２号分を指定した場合_getコードは_003を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード(), is(new RString("003")));
    }

    @Test
    public void 保険者_利用者負担減額_免除認定_総括を指定した場合_getコードは_004を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.getコード(), is(new RString("004")));
    }

    @Test
    public void 保険者_利用者負担減額_免除認定_再掲_第２号分を指定した場合_getコードは_005を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.getコード(), is(new RString("005")));
    }

    @Test
    public void 保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括を指定した場合_getコードは_006を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード(), is(new RString("006")));
    }

    @Test
    public void 保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を指定した場合_getコードは_007を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード(), is(new RString("007")));
    }

    @Test
    public void 保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を指定した場合_getコードは_008を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード(), is(new RString("008")));
    }

    @Test
    public void 保険者_利用者負担第４段階食費_居住費の特例減額措置を指定した場合_getコードは_009を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.getコード(), is(new RString("009")));
    }

    @Test
    public void 保険者_要介護_要支援_認定者数を指定した場合_getコードは_010を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.getコード(), is(new RString("010")));
    }

    @Test
    public void 保険者_現物分_居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_011を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("011")));
    }

    @Test
    public void 保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_012を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("012")));
    }

    @Test
    public void 保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_013を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("013")));
    }

    @Test
    public void 保険者_現物分_地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_014を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("014")));
    }

    @Test
    public void 保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_015を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("015")));
    }

    @Test
    public void 保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_016を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("016")));
    }

    @Test
    public void 保険者_現物分_施設介護サービス受給者数を指定した場合_getコードは_017を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.getコード(), is(new RString("017")));
    }

    @Test
    public void 保険者_償還_審査年月__施設介護サービス受給者数を指定した場合_getコードは_018を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.getコード(), is(new RString("018")));
    }

    @Test
    public void 保険者_償還_決定年月__施設介護サービス受給者数を指定した場合_getコードは_019を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.getコード(), is(new RString("019")));
    }

    @Test
    public void 保険者__別紙_第１号被保険者のいる世帯を指定した場合_getコードは_020を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.getコード(), is(new RString("020")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付1総数を指定した場合_getコードは_021を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.getコード(), is(new RString("021")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_022を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("022")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付3総数特例分を指定した場合_getコードは_023を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.getコード(), is(new RString("023")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_024を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("024")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付1総数を指定した場合_getコードは_025を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.getコード(), is(new RString("025")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_026を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("026")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付3総数特例分を指定した場合_getコードは_027を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.getコード(), is(new RString("027")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_028を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("028")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付1総数を指定した場合_getコードは_029を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.getコード(), is(new RString("029")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_030を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("030")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付3総数特例分を指定した場合_getコードは_031を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.getコード(), is(new RString("031")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_032を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("032")));
    }

    @Test
    public void 保険者_現物分_特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_033を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("033")));
    }

    @Test
    public void 保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_034を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("034")));
    }

    @Test
    public void 保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_035を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("035")));
    }

    @Test
    public void 保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_036を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("036")));
    }

    @Test
    public void 保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_037を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("037")));
    }

    @Test
    public void 保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_038を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("038")));
    }

    @Test
    public void 保険者_高額介護_介護予防_サービス費を指定した場合_getコードは_039を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.getコード(), is(new RString("039")));
    }

    @Test
    public void 保険者_高額医療合算介護_介護予防_サービス費を指定した場合_getコードは_040を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.getコード(), is(new RString("040")));
    }

    @Test
    public void 構成市町村_第１号被保険者数_第１号被保険者増減内訳を指定した場合_getコードは_101を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.getコード(), is(new RString("101")));
    }

    @Test
    public void 構成市町村_食費_居住費に係る負担限度額認定_総括を指定した場合_getコードは_102を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.getコード(), is(new RString("102")));
    }

    @Test
    public void 構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を指定した場合_getコードは_103を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード(), is(new RString("103")));
    }

    @Test
    public void 構成市町村_利用者負担減額_免除認定_総括を指定した場合_getコードは_104を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.getコード(), is(new RString("104")));
    }

    @Test
    public void 構成市町村_利用者負担減額_免除認定_再掲_第２号分を指定した場合_getコードは_105を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.getコード(), is(new RString("105")));
    }

    @Test
    public void 構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を指定した場合_getコードは_106を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード(), is(new RString("106")));
    }

    @Test
    public void 構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を指定した場合_getコードは_107を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード(), is(new RString("107")));
    }

    @Test
    public void 構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を指定した場合_getコードは_108を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード(), is(new RString("108")));
    }

    @Test
    public void 構成市町村_利用者負担第４段階食費_居住費の特例減額措置を指定した場合_getコードは_109を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード(), is(new RString("109")));
    }

    @Test
    public void 構成市町村_要介護_要支援_認定者数を指定した場合_getコードは_110を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.getコード(), is(new RString("110")));
    }

    @Test
    public void 構成市町村_現物分_居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_111を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("111")));
    }

    @Test
    public void 構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_112を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("112")));
    }

    @Test
    public void 構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_113を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("113")));
    }

    @Test
    public void 構成市町村_現物分_地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_114を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("114")));
    }

    @Test
    public void 構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_115を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("115")));
    }

    @Test
    public void 構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_116を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("116")));
    }

    @Test
    public void 構成市町村_現物分_施設介護サービス受給者数を指定した場合_getコードは_117を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.getコード(), is(new RString("117")));
    }

    @Test
    public void 構成市町村_償還_審査年月__施設介護サービス受給者数を指定した場合_getコードは_118を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.getコード(), is(new RString("118")));
    }

    @Test
    public void 構成市町村_償還_決定年月__施設介護サービス受給者数を指定した場合_getコードは_119を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.getコード(), is(new RString("119")));
    }

    @Test
    public void 構成市町村__別紙_第１号被保険者のいる世帯を指定した場合_getコードは_120を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.getコード(), is(new RString("120")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付1総数を指定した場合_getコードは_121を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.getコード(), is(new RString("121")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_122を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("122")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付3総数特例分を指定した場合_getコードは_123を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.getコード(), is(new RString("123")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_124を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("124")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付1総数を指定した場合_getコードは_125を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.getコード(), is(new RString("125")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_126を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("126")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付3総数特例分を指定した場合_getコードは_127を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード(), is(new RString("127")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_128を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("128")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付1総数を指定した場合_getコードは_129を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.getコード(), is(new RString("129")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_130を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("130")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付3総数特例分を指定した場合_getコードは_131を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード(), is(new RString("131")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_132を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("132")));
    }

    @Test
    public void 構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_133を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("133")));
    }

    @Test
    public void 構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_134を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("134")));
    }

    @Test
    public void 構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_135を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("135")));
    }

    @Test
    public void 構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_136を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("136")));
    }

    @Test
    public void 構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_137を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("137")));
    }

    @Test
    public void 構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_138を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("138")));
    }

    @Test
    public void 構成市町村_高額介護_介護予防_サービス費を指定した場合_getコードは_139を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.getコード(), is(new RString("139")));
    }

    @Test
    public void 構成市町村_高額医療合算介護_介護予防_サービス費を指定した場合_getコードは_140を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.getコード(), is(new RString("140")));
    }

    @Test
    public void 旧市町村_第１号被保険者数_第１号被保険者増減内訳を指定した場合_getコードは_201を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.getコード(), is(new RString("201")));
    }

    @Test
    public void 旧市町村_食費_居住費に係る負担限度額認定_総括を指定した場合_getコードは_202を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.getコード(), is(new RString("202")));
    }

    @Test
    public void 旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を指定した場合_getコードは_203を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード(), is(new RString("203")));
    }

    @Test
    public void 旧市町村_利用者負担減額_免除認定_総括を指定した場合_getコードは_204を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.getコード(), is(new RString("204")));
    }

    @Test
    public void 旧市町村_利用者負担減額_免除認定_再掲_第２号分を指定した場合_getコードは_205を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.getコード(), is(new RString("205")));
    }

    @Test
    public void 旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を指定した場合_getコードは_206を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード(), is(new RString("206")));
    }

    @Test
    public void 旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を指定した場合_getコードは_207を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード(), is(new RString("207")));
    }

    @Test
    public void 旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を指定した場合_getコードは_208を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード(), is(new RString("208")));
    }

    @Test
    public void 旧市町村_利用者負担第４段階食費_居住費の特例減額措置を指定した場合_getコードは_209を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード(), is(new RString("209")));
    }

    @Test
    public void 旧市町村_要介護_要支援_認定者数を指定した場合_getコードは_210を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.getコード(), is(new RString("210")));
    }

    @Test
    public void 旧市町村_現物分_居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_211を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("211")));
    }

    @Test
    public void 旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_212を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("212")));
    }

    @Test
    public void 旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を指定した場合_getコードは_213を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード(), is(new RString("213")));
    }

    @Test
    public void 旧市町村_現物分_地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_214を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("214")));
    }

    @Test
    public void 旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_215を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("215")));
    }

    @Test
    public void 旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を指定した場合_getコードは_216を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード(), is(new RString("216")));
    }

    @Test
    public void 旧市町村_現物分_施設介護サービス受給者数を指定した場合_getコードは_217を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.getコード(), is(new RString("217")));
    }

    @Test
    public void 旧市町村_償還_審査年月__施設介護サービス受給者数を指定した場合_getコードは_218を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.getコード(), is(new RString("218")));
    }

    @Test
    public void 旧市町村_償還_決定年月__施設介護サービス受給者数を指定した場合_getコードは_219を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.getコード(), is(new RString("219")));
    }

    @Test
    public void 旧市町村__別紙_第１号被保険者のいる世帯を指定した場合_getコードは_220を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.getコード(), is(new RString("220")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付1総数を指定した場合_getコードは_221を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.getコード(), is(new RString("221")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_222を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("222")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付3総数特例分を指定した場合_getコードは_223を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.getコード(), is(new RString("223")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_224を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("224")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付1総数を指定した場合_getコードは_225を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.getコード(), is(new RString("225")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_226を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("226")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付3総数特例分を指定した場合_getコードは_227を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード(), is(new RString("227")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_228を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("228")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付1総数を指定した場合_getコードは_229を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.getコード(), is(new RString("229")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_getコードは_230を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード(), is(new RString("230")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付3総数特例分を指定した場合_getコードは_231を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード(), is(new RString("231")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_getコードは_232を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード(), is(new RString("232")));
    }

    @Test
    public void 旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_233を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("233")));
    }

    @Test
    public void 旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_234を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("234")));
    }

    @Test
    public void 旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_235を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("235")));
    }

    @Test
    public void 旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_236を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("236")));
    }

    @Test
    public void 旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_getコードは_237を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード(), is(new RString("237")));
    }

    @Test
    public void 旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_getコードは_238を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード(), is(new RString("238")));
    }

    @Test
    public void 旧市町村_高額介護_介護予防_サービス費を指定した場合_getコードは_239を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.getコード(), is(new RString("239")));
    }

    @Test
    public void 旧市町村_高額医療合算介護_介護予防_サービス費を指定した場合_getコードは_240を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.getコード(), is(new RString("240")));
    }

    @Test
    public void 保険者_第１号被保険者数_第１号被保険者増減内訳を指定した場合_get名称は_保険者_第１号被保険者数_第１号被保険者増減内訳を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.get名称(), is(new RString("保険者／第１号被保険者数・第１号被保険者増減内訳")));
    }

    @Test
    public void 保険者_食費_居住費に係る負担限度額認定_総括を指定した場合_get名称は_保険者_食費_居住費に係る負担限度額認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.get名称(), is(new RString("保険者／食費・居住費に係る負担限度額認定（総括）")));
    }

    @Test
    public void 保険者_食費_居住費に係る負担限度額認定_再掲_第２号分を指定した場合_get名称は_保険者_食費_居住費に係る負担限度額認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称(), is(new RString("保険者／食費・居住費に係る負担限度額認定（再掲：第２号分）")));
    }

    @Test
    public void 保険者_利用者負担減額_免除認定_総括を指定した場合_get名称は_保険者_利用者負担減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.get名称(), is(new RString("保険者／利用者負担減額・免除認定（総括）")));
    }

    @Test
    public void 保険者_利用者負担減額_免除認定_再掲_第２号分を指定した場合_get名称は_保険者_利用者負担減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.get名称(), is(new RString("保険者／利用者負担減額・免除認定（再掲：第２号分）")));
    }

    @Test
    public void 保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括を指定した場合_get名称は_保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称(), is(new RString("保険者／介護老人福祉施設旧措置入所者減額・免除認定（総括）")));
    }

    @Test
    public void 保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を指定した場合_get名称は_保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称(), is(new RString("保険者／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分）")));
    }

    @Test
    public void 保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を指定した場合_get名称は_保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称(), is(new RString("保険者／食費・居住費負担限度額認定（再掲：税制改正激変緩和者）")));
    }

    @Test
    public void 保険者_利用者負担第４段階食費_居住費の特例減額措置を指定した場合_get名称は_保険者_利用者負担第４段階食費_居住費の特例減額措置を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.get名称(), is(new RString("保険者／利用者負担第４段階食費・居住費の特例減額措置")));
    }

    @Test
    public void 保険者_要介護_要支援_認定者数を指定した場合_get名称は_保険者_要介護_要支援_認定者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.get名称(), is(new RString("保険者／要介護（要支援）認定者数")));
    }

    @Test
    public void 保険者_現物分_居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_保険者_現物分_居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("保険者／現物分／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("保険者／償還（審査年月）／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("保険者／償還（決定年月）／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 保険者_現物分_地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_保険者_現物分_地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("保険者／現物分／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("保険者／償還（審査年月）／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("保険者／償還（決定年月）／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 保険者_現物分_施設介護サービス受給者数を指定した場合_get名称は_保険者_現物分_施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.get名称(), is(new RString("保険者／現物分／施設介護サービス受給者数")));
    }

    @Test
    public void 保険者_償還_審査年月__施設介護サービス受給者数を指定した場合_get名称は_保険者_償還_審査年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.get名称(), is(new RString("保険者／償還（審査年月）／施設介護サービス受給者数")));
    }

    @Test
    public void 保険者_償還_決定年月__施設介護サービス受給者数を指定した場合_get名称は_保険者_償還_決定年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.get名称(), is(new RString("保険者／償還（決定年月）／施設介護サービス受給者数")));
    }

    @Test
    public void 保険者__別紙_第１号被保険者のいる世帯を指定した場合_get名称は_保険者__別紙_第１号被保険者のいる世帯を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.get名称(), is(new RString("保険者／（別紙）第１号被保険者のいる世帯")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付1総数を指定した場合_get名称は_保険者_現物分_介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.get名称(), is(new RString("保険者／現物分／介護給付・予防給付①総数")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("保険者／現物分／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付3総数特例分を指定した場合_get名称は_保険者_現物分_介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.get名称(), is(new RString("保険者／現物分／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("保険者／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付1総数を指定した場合_get名称は_保険者_償還_審査年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.get名称(), is(new RString("保険者／償還（審査年月）／介護給付・予防給付①総数")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("保険者／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付3総数特例分を指定した場合_get名称は_保険者_償還_審査年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.get名称(), is(new RString("保険者／償還（審査年月）／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("保険者／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付1総数を指定した場合_get名称は_保険者_償還_決定年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.get名称(), is(new RString("保険者／償還（決定年月）／介護給付・予防給付①総数")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("保険者／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付3総数特例分を指定した場合_get名称は_保険者_償還_決定年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.get名称(), is(new RString("保険者／償還（決定年月）／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("保険者／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 保険者_現物分_特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_保険者_現物分_特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("保険者／現物分／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("保険者／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("保険者／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("保険者／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("保険者／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("保険者／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 保険者_高額介護_介護予防_サービス費を指定した場合_get名称は_保険者_高額介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.get名称(), is(new RString("保険者／高額介護（介護予防）サービス費")));
    }

    @Test
    public void 保険者_高額医療合算介護_介護予防_サービス費を指定した場合_get名称は_保険者_高額医療合算介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.get名称(), is(new RString("保険者／高額医療合算介護（介護予防）サービス費")));
    }

    @Test
    public void 構成市町村_第１号被保険者数_第１号被保険者増減内訳を指定した場合_get名称は_構成市町村_第１号被保険者数_第１号被保険者増減内訳を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.get名称(), is(new RString("構成市町村／第１号被保険者数・第１号被保険者増減内訳")));
    }

    @Test
    public void 構成市町村_食費_居住費に係る負担限度額認定_総括を指定した場合_get名称は_構成市町村_食費_居住費に係る負担限度額認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.get名称(), is(new RString("構成市町村／食費・居住費に係る負担限度額認定（総括）")));
    }

    @Test
    public void 構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を指定した場合_get名称は_構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称(), is(new RString("構成市町村／食費・居住費に係る負担限度額認定（再掲：第２号分）")));
    }

    @Test
    public void 構成市町村_利用者負担減額_免除認定_総括を指定した場合_get名称は_構成市町村_利用者負担減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.get名称(), is(new RString("構成市町村／利用者負担減額・免除認定（総括）")));
    }

    @Test
    public void 構成市町村_利用者負担減額_免除認定_再掲_第２号分を指定した場合_get名称は_構成市町村_利用者負担減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.get名称(), is(new RString("構成市町村／利用者負担減額・免除認定（再掲：第２号分）")));
    }

    @Test
    public void 構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を指定した場合_get名称は_構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称(), is(new RString("構成市町村／介護老人福祉施設旧措置入所者減額・免除認定（総括）")));
    }

    @Test
    public void 構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を指定した場合_get名称は_構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称(), is(new RString("構成市町村／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分）")));
    }

    @Test
    public void 構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を指定した場合_get名称は_構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称(), is(new RString("構成市町村／食費・居住費負担限度額認定（再掲：税制改正激変緩和者）")));
    }

    @Test
    public void 構成市町村_利用者負担第４段階食費_居住費の特例減額措置を指定した場合_get名称は_構成市町村_利用者負担第４段階食費_居住費の特例減額措置を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.get名称(), is(new RString("構成市町村／利用者負担第４段階食費・居住費の特例減額措置")));
    }

    @Test
    public void 構成市町村_要介護_要支援_認定者数を指定した場合_get名称は_構成市町村_要介護_要支援_認定者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.get名称(), is(new RString("構成市町村／要介護（要支援）認定者数")));
    }

    @Test
    public void 構成市町村_現物分_居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_構成市町村_現物分_居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("構成市町村／現物分／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("構成市町村／償還（審査年月）／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("構成市町村／償還（決定年月）／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 構成市町村_現物分_地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_構成市町村_現物分_地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("構成市町村／現物分／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("構成市町村／償還（審査年月）／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("構成市町村／償還（決定年月）／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 構成市町村_現物分_施設介護サービス受給者数を指定した場合_get名称は_構成市町村_現物分_施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.get名称(), is(new RString("構成市町村／現物分／施設介護サービス受給者数")));
    }

    @Test
    public void 構成市町村_償還_審査年月__施設介護サービス受給者数を指定した場合_get名称は_構成市町村_償還_審査年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.get名称(), is(new RString("構成市町村／償還（審査年月）／施設介護サービス受給者数")));
    }

    @Test
    public void 構成市町村_償還_決定年月__施設介護サービス受給者数を指定した場合_get名称は_構成市町村_償還_決定年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.get名称(), is(new RString("構成市町村／償還（決定年月）／施設介護サービス受給者数")));
    }

    @Test
    public void 構成市町村__別紙_第１号被保険者のいる世帯を指定した場合_get名称は_構成市町村__別紙_第１号被保険者のいる世帯を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.get名称(), is(new RString("構成市町村／（別紙）第１号被保険者のいる世帯")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付1総数を指定した場合_get名称は_構成市町村_現物分_介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.get名称(), is(new RString("構成市町村／現物分／介護給付・予防給付①総数")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("構成市町村／現物分／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付3総数特例分を指定した場合_get名称は_構成市町村_現物分_介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.get名称(), is(new RString("構成市町村／現物分／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("構成市町村／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付1総数を指定した場合_get名称は_構成市町村_償還_審査年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.get名称(), is(new RString("構成市町村／償還（審査年月）／介護給付・予防給付①総数")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("構成市町村／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付3総数特例分を指定した場合_get名称は_構成市町村_償還_審査年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.get名称(), is(new RString("構成市町村／償還（審査年月）／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("構成市町村／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付1総数を指定した場合_get名称は_構成市町村_償還_決定年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.get名称(), is(new RString("構成市町村／償還（決定年月）／介護給付・予防給付①総数")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("構成市町村／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付3総数特例分を指定した場合_get名称は_構成市町村_償還_決定年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.get名称(), is(new RString("構成市町村／償還（決定年月）／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("構成市町村／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("構成市町村／現物分／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("構成市町村／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("構成市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("構成市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("構成市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("構成市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 構成市町村_高額介護_介護予防_サービス費を指定した場合_get名称は_構成市町村_高額介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.get名称(), is(new RString("構成市町村／高額介護（介護予防）サービス費")));
    }

    @Test
    public void 構成市町村_高額医療合算介護_介護予防_サービス費を指定した場合_get名称は_構成市町村_高額医療合算介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.get名称(), is(new RString("構成市町村／高額医療合算介護（介護予防）サービス費")));
    }

    @Test
    public void 旧市町村_第１号被保険者数_第１号被保険者増減内訳を指定した場合_get名称は_旧市町村_第１号被保険者数_第１号被保険者増減内訳を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.get名称(), is(new RString("旧市町村／第１号被保険者数・第１号被保険者増減内訳")));
    }

    @Test
    public void 旧市町村_食費_居住費に係る負担限度額認定_総括を指定した場合_get名称は_旧市町村_食費_居住費に係る負担限度額認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.get名称(), is(new RString("旧市町村／食費・居住費に係る負担限度額認定（総括）")));
    }

    @Test
    public void 旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を指定した場合_get名称は_旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称(), is(new RString("旧市町村／食費・居住費に係る負担限度額認定（再掲：第２号分）")));
    }

    @Test
    public void 旧市町村_利用者負担減額_免除認定_総括を指定した場合_get名称は_旧市町村_利用者負担減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.get名称(), is(new RString("旧市町村／利用者負担減額・免除認定（総括）")));
    }

    @Test
    public void 旧市町村_利用者負担減額_免除認定_再掲_第２号分を指定した場合_get名称は_旧市町村_利用者負担減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.get名称(), is(new RString("旧市町村／利用者負担減額・免除認定（再掲：第２号分）")));
    }

    @Test
    public void 旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を指定した場合_get名称は_旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称(), is(new RString("旧市町村／介護老人福祉施設旧措置入所者減額・免除認定（総括）")));
    }

    @Test
    public void 旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を指定した場合_get名称は_旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称(), is(new RString("旧市町村／介護老人福祉施設旧措置入所者減額・免除認定（再掲：第２号分）")));
    }

    @Test
    public void 旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を指定した場合_get名称は_旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称(), is(new RString("旧市町村／食費・居住費負担限度額認定（再掲：税制改正激変緩和者）")));
    }

    @Test
    public void 旧市町村_利用者負担第４段階食費_居住費の特例減額措置を指定した場合_get名称は_旧市町村_利用者負担第４段階食費_居住費の特例減額措置を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.get名称(), is(new RString("旧市町村／利用者負担第４段階食費・居住費の特例減額措置")));
    }

    @Test
    public void 旧市町村_要介護_要支援_認定者数を指定した場合_get名称は_旧市町村_要介護_要支援_認定者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.get名称(), is(new RString("旧市町村／要介護（要支援）認定者数")));
    }

    @Test
    public void 旧市町村_現物分_居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_旧市町村_現物分_居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("旧市町村／現物分／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("旧市町村／償還（審査年月）／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を指定した場合_get名称は_旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称(), is(new RString("旧市町村／償還（決定年月）／居宅介護（介護予防）サービス受給者数")));
    }

    @Test
    public void 旧市町村_現物分_地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_旧市町村_現物分_地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("旧市町村／現物分／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("旧市町村／償還（審査年月）／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を指定した場合_get名称は_旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称(), is(new RString("旧市町村／償還（決定年月）／地域密着型（介護予防）サービス受給者数")));
    }

    @Test
    public void 旧市町村_現物分_施設介護サービス受給者数を指定した場合_get名称は_旧市町村_現物分_施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.get名称(), is(new RString("旧市町村／現物分／施設介護サービス受給者数")));
    }

    @Test
    public void 旧市町村_償還_審査年月__施設介護サービス受給者数を指定した場合_get名称は_旧市町村_償還_審査年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.get名称(), is(new RString("旧市町村／償還（審査年月）／施設介護サービス受給者数")));
    }

    @Test
    public void 旧市町村_償還_決定年月__施設介護サービス受給者数を指定した場合_get名称は_旧市町村_償還_決定年月__施設介護サービス受給者数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.get名称(), is(new RString("旧市町村／償還（決定年月）／施設介護サービス受給者数")));
    }

    @Test
    public void 旧市町村__別紙_第１号被保険者のいる世帯を指定した場合_get名称は_旧市町村__別紙_第１号被保険者のいる世帯を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.get名称(), is(new RString("旧市町村／（別紙）第１号被保険者のいる世帯")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付1総数を指定した場合_get名称は_旧市町村_現物分_介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.get名称(), is(new RString("旧市町村／現物分／介護給付・予防給付①総数")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("旧市町村／現物分／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付3総数特例分を指定した場合_get名称は_旧市町村_現物分_介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.get名称(), is(new RString("旧市町村／現物分／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("旧市町村／現物分／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付1総数を指定した場合_get名称は_旧市町村_償還_審査年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.get名称(), is(new RString("旧市町村／償還（審査年月）／介護給付・予防給付①総数")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("旧市町村／償還（審査年月）／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付3総数特例分を指定した場合_get名称は_旧市町村_償還_審査年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.get名称(), is(new RString("旧市町村／償還（審査年月）／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("旧市町村／償還（審査年月）／介護給付・予防給付④第２号被保険者分（再掲：特例分）")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付1総数を指定した場合_get名称は_旧市町村_償還_決定年月__介護給付_予防給付1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.get名称(), is(new RString("旧市町村／償還（決定年月）／介護給付・予防給付①総数")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を指定した場合_get名称は_旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称(), is(new RString("旧市町村／償還（決定年月）／介護給付・予防給付②第２号被保険者分（再掲）")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付3総数特例分を指定した場合_get名称は_旧市町村_償還_決定年月__介護給付_予防給付3総数特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.get名称(), is(new RString("旧市町村／償還（決定年月）／介護給付・予防給付③総数特例分")));
    }

    @Test
    public void 旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を指定した場合_get名称は_旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称(), is(new RString("旧市町村／償還（決定年月）／介護給付・予防給付④第２号被保険者分（再掲_特例分）")));
    }

    @Test
    public void 旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("旧市町村／現物分／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("旧市町村／現物分／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("旧市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("旧市町村／償還（審査年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を指定した場合_get名称は_旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称(), is(new RString("旧市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費①総数")));
    }

    @Test
    public void 旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を指定した場合_get名称は_旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称(), is(new RString("旧市町村／償還（決定年月）／特定入所者介護（介護予防）サービス費②第２号被保険者分")));
    }

    @Test
    public void 旧市町村_高額介護_介護予防_サービス費を指定した場合_get名称は_旧市町村_高額介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.get名称(), is(new RString("旧市町村／高額介護（介護予防）サービス費")));
    }

    @Test
    public void 旧市町村_高額医療合算介護_介護予防_サービス費を指定した場合_get名称は_旧市町村_高額医療合算介護_介護予防_サービス費を返す() {
        assertThat(JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.get名称(), is(new RString("旧市町村／高額医療合算介護（介護予防）サービス費")));
    }

}
