package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 一次判定警告コード09のテストクラスです。
 * 
 * @author LDNS 
 */
public class IchijiHanteiKeikokuTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IchijiHanteiKeikoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IchijiHanteiKeikoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("01")), is(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("02")), is(IchijiHanteiKeikoku._起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できる));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("03")), is(IchijiHanteiKeikoku._起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("04")), is(IchijiHanteiKeikoku._座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できる));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("05")), is(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できる));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("06")), is(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できる));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("07")), is(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できる));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("08")), is(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できる));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("09")), is(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("10")), is(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できる));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("11")), is(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できる));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("12")), is(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できる));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("13")), is(IchijiHanteiKeikoku._歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("14")), is(IchijiHanteiKeikoku._歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できる));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("15")), is(IchijiHanteiKeikoku._移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できる));
    }

    @Test
    public void 引数に16を指定した場合_toValueは_立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("16")), is(IchijiHanteiKeikoku._立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できる));
    }

    @Test
    public void 引数に17を指定した場合_toValueは_えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("17")), is(IchijiHanteiKeikoku._えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立));
    }

    @Test
    public void 引数に18を指定した場合_toValueは_えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("18")), is(IchijiHanteiKeikoku._えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立));
    }

    @Test
    public void 引数に19を指定した場合_toValueは_つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("19")), is(IchijiHanteiKeikoku._つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある));
    }

    @Test
    public void 引数に20を指定した場合_toValueは_薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("20")), is(IchijiHanteiKeikoku._薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("21")), is(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.ある));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("22")), is(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.ある));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("23")), is(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.ある));
    }

    @Test
    public void 引数に24を指定した場合_toValueは_金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("24")), is(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある));
    }

    @Test
    public void 引数に25を指定した場合_toValueは_視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("25")), is(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できる));
    }

    @Test
    public void 引数に26を指定した場合_toValueは_聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("26")), is(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できる));
    }

    @Test
    public void 引数に27を指定した場合_toValueは_視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("27")), is(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できる));
    }

    @Test
    public void 引数に28を指定した場合_toValueは_聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("28")), is(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できる));
    }

    @Test
    public void 引数に29を指定した場合_toValueは_聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("29")), is(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できる));
    }

    @Test
    public void 引数に30を指定した場合_toValueは_視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("30")), is(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できる));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("31")), is(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立));
    }

    @Test
    public void 引数に32を指定した場合_toValueは_意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("32")), is(IchijiHanteiKeikoku._意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できる));
    }

    @Test
    public void 引数に33を指定した場合_toValueは_聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("33")), is(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立));
    }

    @Test
    public void 引数に34を指定した場合_toValueは_聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("34")), is(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立));
    }

    @Test
    public void 引数に35を指定した場合_toValueは_物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("35")), is(IchijiHanteiKeikoku._物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できる));
    }

    @Test
    public void 引数に36を指定した場合_toValueは_自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("36")), is(IchijiHanteiKeikoku._自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できる));
    }

    @Test
    public void 引数に37を指定した場合_toValueは_視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("37")), is(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立));
    }

    @Test
    public void 引数に38を指定した場合_toValueは_視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("38")), is(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立));
    }

    @Test
    public void 引数に39を指定した場合_toValueは_視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("39")), is(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立));
    }

    @Test
    public void 引数に40を指定した場合_toValueは_座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("40")), is(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できる));
    }

    @Test
    public void 引数に41を指定した場合_toValueは_洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("41")), is(IchijiHanteiKeikoku._洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できる));
    }

    @Test
    public void 引数に42を指定した場合_toValueは_整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("42")), is(IchijiHanteiKeikoku._整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できる));
    }

    @Test
    public void 引数に43を指定した場合_toValueは_金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("43")), is(IchijiHanteiKeikoku._金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できる));
    }

    @Test
    public void 引数に44を指定した場合_toValueは_日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("44")), is(IchijiHanteiKeikoku._日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できる));
    }

    @Test
    public void 引数に45を指定した場合_toValueは_意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("45")), is(IchijiHanteiKeikoku._意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できる));
    }

    @Test
    public void 引数に46を指定した場合_toValueは_物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ないを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("46")), is(IchijiHanteiKeikoku._物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ない));
    }

    @Test
    public void 引数に47を指定した場合_toValueは_寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("47")), is(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できる));
    }

    @Test
    public void 引数に48を指定した場合_toValueは_寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("48")), is(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できる));
    }

    @Test
    public void 引数に49を指定した場合_toValueは_起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できないを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("49")), is(IchijiHanteiKeikoku._起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できない));
    }

    @Test
    public void 引数に50を指定した場合_toValueは_歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("50")), is(IchijiHanteiKeikoku._歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("51")), is(IchijiHanteiKeikoku._移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できる));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("52")), is(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("53")), is(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助));
    }

    @Test
    public void 引数に54を指定した場合_toValueは_洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("54")), is(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助));
    }

    @Test
    public void 引数に55を指定した場合_toValueは_洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("55")), is(IchijiHanteiKeikoku._洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立));
    }

    @Test
    public void 引数に56を指定した場合_toValueは_つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("56")), is(IchijiHanteiKeikoku._つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能));
    }

    @Test
    public void 引数に57を指定した場合_toValueは_上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku.toValue(new RString("57")), is(IchijiHanteiKeikoku._上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立));
    }

    @Test
    public void _寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立を指定した場合_getコードは_01を返す() {
        assertThat(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立.getコード(), is(new RString("01")));
    }

    @Test
    public void _起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_getコードは_02を返す() {
        assertThat(IchijiHanteiKeikoku._起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できる.getコード(), is(new RString("02")));
    }

    @Test
    public void _起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立を指定した場合_getコードは_03を返す() {
        assertThat(IchijiHanteiKeikoku._起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立.getコード(), is(new RString("03")));
    }

    @Test
    public void _座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できるを指定した場合_getコードは_04を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できる.getコード(), is(new RString("04")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できるを指定した場合_getコードは_05を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できる.getコード(), is(new RString("05")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できるを指定した場合_getコードは_06を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できる.getコード(), is(new RString("06")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_getコードは_07を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できる.getコード(), is(new RString("07")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_getコードは_08を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できる.getコード(), is(new RString("08")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立を指定した場合_getコードは_09を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立.getコード(), is(new RString("09")));
    }

    @Test
    public void _両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できるを指定した場合_getコードは_10を返す() {
        assertThat(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できる.getコード(), is(new RString("10")));
    }

    @Test
    public void _両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_getコードは_11を返す() {
        assertThat(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できる.getコード(), is(new RString("11")));
    }

    @Test
    public void _両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_getコードは_12を返す() {
        assertThat(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できる.getコード(), is(new RString("12")));
    }

    @Test
    public void _歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助を指定した場合_getコードは_13を返す() {
        assertThat(IchijiHanteiKeikoku._歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助.getコード(), is(new RString("13")));
    }

    @Test
    public void _歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_getコードは_14を返す() {
        assertThat(IchijiHanteiKeikoku._歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できる.getコード(), is(new RString("14")));
    }

    @Test
    public void _移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できるを指定した場合_getコードは_15を返す() {
        assertThat(IchijiHanteiKeikoku._移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できる.getコード(), is(new RString("15")));
    }

    @Test
    public void _立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_getコードは_16を返す() {
        assertThat(IchijiHanteiKeikoku._立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できる.getコード(), is(new RString("16")));
    }

    @Test
    public void _えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立を指定した場合_getコードは_17を返す() {
        assertThat(IchijiHanteiKeikoku._えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立.getコード(), is(new RString("17")));
    }

    @Test
    public void _えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立を指定した場合_getコードは_18を返す() {
        assertThat(IchijiHanteiKeikoku._えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立.getコード(), is(new RString("18")));
    }

    @Test
    public void _つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを指定した場合_getコードは_19を返す() {
        assertThat(IchijiHanteiKeikoku._つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある.getコード(), is(new RString("19")));
    }

    @Test
    public void _薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを指定した場合_getコードは_20を返す() {
        assertThat(IchijiHanteiKeikoku._薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある.getコード(), is(new RString("20")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.あるを指定した場合_getコードは_21を返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.ある.getコード(), is(new RString("21")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.あるを指定した場合_getコードは_22を返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.ある.getコード(), is(new RString("22")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.あるを指定した場合_getコードは_23を返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.ある.getコード(), is(new RString("23")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを指定した場合_getコードは_24を返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある.getコード(), is(new RString("24")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを指定した場合_getコードは_25を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できる.getコード(), is(new RString("25")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを指定した場合_getコードは_26を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できる.getコード(), is(new RString("26")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを指定した場合_getコードは_27を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できる.getコード(), is(new RString("27")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを指定した場合_getコードは_28を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できる.getコード(), is(new RString("28")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_getコードは_29を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できる.getコード(), is(new RString("29")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_getコードは_30を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できる.getコード(), is(new RString("30")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を指定した場合_getコードは_31を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立.getコード(), is(new RString("31")));
    }

    @Test
    public void _意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_getコードは_32を返す() {
        assertThat(IchijiHanteiKeikoku._意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できる.getコード(), is(new RString("32")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を指定した場合_getコードは_33を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立.getコード(), is(new RString("33")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を指定した場合_getコードは_34を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立.getコード(), is(new RString("34")));
    }

    @Test
    public void _物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_getコードは_35を返す() {
        assertThat(IchijiHanteiKeikoku._物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できる.getコード(), is(new RString("35")));
    }

    @Test
    public void _自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_getコードは_36を返す() {
        assertThat(IchijiHanteiKeikoku._自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できる.getコード(), is(new RString("36")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を指定した場合_getコードは_37を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立.getコード(), is(new RString("37")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を指定した場合_getコードは_38を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立.getコード(), is(new RString("38")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を指定した場合_getコードは_39を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立.getコード(), is(new RString("39")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できるを指定した場合_getコードは_40を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できる.getコード(), is(new RString("40")));
    }

    @Test
    public void _洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを指定した場合_getコードは_41を返す() {
        assertThat(IchijiHanteiKeikoku._洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できる.getコード(), is(new RString("41")));
    }

    @Test
    public void _整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを指定した場合_getコードは_42を返す() {
        assertThat(IchijiHanteiKeikoku._整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できる.getコード(), is(new RString("42")));
    }

    @Test
    public void _金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できるを指定した場合_getコードは_43を返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できる.getコード(), is(new RString("43")));
    }

    @Test
    public void _日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できるを指定した場合_getコードは_44を返す() {
        assertThat(IchijiHanteiKeikoku._日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できる.getコード(), is(new RString("44")));
    }

    @Test
    public void _意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できるを指定した場合_getコードは_45を返す() {
        assertThat(IchijiHanteiKeikoku._意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できる.getコード(), is(new RString("45")));
    }

    @Test
    public void _物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ないを指定した場合_getコードは_46を返す() {
        assertThat(IchijiHanteiKeikoku._物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ない.getコード(), is(new RString("46")));
    }

    @Test
    public void _寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できるを指定した場合_getコードは_47を返す() {
        assertThat(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できる.getコード(), is(new RString("47")));
    }

    @Test
    public void _寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_getコードは_48を返す() {
        assertThat(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できる.getコード(), is(new RString("48")));
    }

    @Test
    public void _起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できないを指定した場合_getコードは_49を返す() {
        assertThat(IchijiHanteiKeikoku._起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できない.getコード(), is(new RString("49")));
    }

    @Test
    public void _歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助を指定した場合_getコードは_50を返す() {
        assertThat(IchijiHanteiKeikoku._歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助.getコード(), is(new RString("50")));
    }

    @Test
    public void _移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_getコードは_51を返す() {
        assertThat(IchijiHanteiKeikoku._移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できる.getコード(), is(new RString("51")));
    }

    @Test
    public void _洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助を指定した場合_getコードは_52を返す() {
        assertThat(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助.getコード(), is(new RString("52")));
    }

    @Test
    public void _洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助を指定した場合_getコードは_53を返す() {
        assertThat(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助.getコード(), is(new RString("53")));
    }

    @Test
    public void _洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助を指定した場合_getコードは_54を返す() {
        assertThat(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助.getコード(), is(new RString("54")));
    }

    @Test
    public void _洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立を指定した場合_getコードは_55を返す() {
        assertThat(IchijiHanteiKeikoku._洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立.getコード(), is(new RString("55")));
    }

    @Test
    public void _つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能を指定した場合_getコードは_56を返す() {
        assertThat(IchijiHanteiKeikoku._つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能.getコード(), is(new RString("56")));
    }

    @Test
    public void _上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立を指定した場合_getコードは_57を返す() {
        assertThat(IchijiHanteiKeikoku._上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立.getコード(), is(new RString("57")));
    }

    @Test
    public void _寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立を指定した場合_get名称は__寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_洗身_が_1.自立.get名称(), is(new RString("「寝返り」が「3.できない」にもかかわらず、「洗身」が「1.自立」")));
    }

    @Test
    public void _起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_get名称は__起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._起き上がり_が_3.できない_にもかかわらず、_立ち上がり_が_1.できる.get名称(), is(new RString("「起き上がり」が「3.できない」にもかかわらず、「立ち上がり」が「1.できる」")));
    }

    @Test
    public void _起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立を指定した場合_get名称は__起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._起き上がり_が_3.できない_にもかかわらず、_洗身_が_1.自立.get名称(), is(new RString("「起き上がり」が「3.できない」にもかかわらず、「洗身」が「1.自立」")));
    }

    @Test
    public void _座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できるを指定した場合_get名称は__座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_3.支えが必要_にもかかわらず、_片足での立位_が_1.できる.get名称(), is(new RString("「座位保持」が「3.支えが必要」にもかかわらず、「片足での立位」が「1.できる」")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できるを指定した場合_get名称は__座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_両足での立位_が_1.できる.get名称(), is(new RString("「座位保持」が「4.できない」にもかかわらず、「両足での立位」が「1.できる」")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できるを指定した場合_get名称は__座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_歩行_が_1.できる.get名称(), is(new RString("「座位保持」が「4.できない」にもかかわらず、「歩行」が「1.できる」")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_get名称は__座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_立ち上がり_が_1.できる.get名称(), is(new RString("「座位保持」が「4.できない」にもかかわらず、「立ち上がり」が「1.できる」")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_get名称は__座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_片足での立位_が_1.できる.get名称(), is(new RString("「座位保持」が「4.できない」にもかかわらず、「片足での立位」が「1.できる」")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立を指定した場合_get名称は__座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_洗身_が_1.自立.get名称(), is(new RString("「座位保持」が「4.できない」にもかかわらず、「洗身」が「1.自立」")));
    }

    @Test
    public void _両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できるを指定した場合_get名称は__両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_歩行_が_1.できる.get名称(), is(new RString("「両足での立位」が「4.できない」にもかかわらず、「歩行」が「1.できる」")));
    }

    @Test
    public void _両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_get名称は__両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_立ち上がり_が_1.できる.get名称(), is(new RString("「両足での立位」が「4.できない」にもかかわらず、「立ち上がり」が「1.できる」")));
    }

    @Test
    public void _両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_get名称は__両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._両足での立位_が_4.できない_にもかかわらず、_片足での立位_が_1.できる.get名称(), is(new RString("「両足での立位」が「4.できない」にもかかわらず、「片足での立位」が「1.できる」")));
    }

    @Test
    public void _歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助を指定した場合_get名称は__歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku._歩行_が_1.できる_にもかかわらず、_移乗_が_4.全介助.get名称(), is(new RString("「歩行」が「1.できる」にもかかわらず、「移乗」が「4.全介助」")));
    }

    @Test
    public void _歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_get名称は__歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._歩行_が_3.できない_にもかかわらず、_片足での立位_が_1.できる.get名称(), is(new RString("「歩行」が「3.できない」にもかかわらず、「片足での立位」が「1.できる」")));
    }

    @Test
    public void _移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できるを指定した場合_get名称は__移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._移乗_が_4.全介助_にもかかわらず、_片足での立位_が_1.できる.get名称(), is(new RString("「移乗」が「4.全介助」にもかかわらず、「片足での立位」が「1.できる」")));
    }

    @Test
    public void _立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを指定した場合_get名称は__立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._立ち上がり_が_3.できない_にもかかわらず、_片足での立位_が_1.できる.get名称(), is(new RString("「立ち上がり」が「3.できない」にもかかわらず、「片足での立位」が「1.できる」")));
    }

    @Test
    public void _えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立を指定した場合_get名称は__えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._えん下_が_3.できない_にもかかわらず、_食事摂取_が_1.自立.get名称(), is(new RString("「えん下」が「3.できない」にもかかわらず、「食事摂取」が「1.自立」")));
    }

    @Test
    public void _えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立を指定した場合_get名称は__えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._えん下_が_3.できない_にもかかわらず、_薬の内服_が_1.自立.get名称(), is(new RString("「えん下」が「3.できない」にもかかわらず、「薬の内服」が「1.自立」")));
    }

    @Test
    public void _つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを指定した場合_get名称は__つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku._つめ切り_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある.get名称(), is(new RString("「つめ切り」が「1.自立」にもかかわらず、「物や衣類を壊す」が「3.ある」")));
    }

    @Test
    public void _薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを指定した場合_get名称は__薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku._薬の内服_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある.get名称(), is(new RString("「薬の内服」が「1.自立」にもかかわらず、「物や衣類を壊す」が「3.ある」")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.あるを指定した場合_get名称は__金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_徘徊_が_3.ある.get名称(), is(new RString("「金銭の管理」が「1.自立」にもかかわらず、「徘徊」が「3.ある」")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.あるを指定した場合_get名称は__金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_一人で出たがる_が_3.ある.get名称(), is(new RString("「金銭の管理」が「1.自立」にもかかわらず、「一人で出たがる」が「3.ある」")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.あるを指定した場合_get名称は__金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_収集癖_が_3.ある.get名称(), is(new RString("「金銭の管理」が「1.自立」にもかかわらず、「収集癖」が「3.ある」")));
    }

    @Test
    public void _金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを指定した場合_get名称は__金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.あるを返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_1.自立_にもかかわらず、_物や衣類を壊す_が_3.ある.get名称(), is(new RString("「金銭の管理」が「1.自立」にもかかわらず、「物や衣類を壊す」が「3.ある」")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを指定した場合_get名称は__視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できる.get名称(), is(new RString("「視力」が「5.判断不能」にもかかわらず、「意思の伝達」が「1.できる」")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを指定した場合_get名称は__聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_意思の伝達_が_1.できる.get名称(), is(new RString("「聴力」が「5.判断不能」にもかかわらず、「意思の伝達」が「1.できる」")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを指定した場合_get名称は__視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できる.get名称(), is(new RString("「視力」が「5.判断不能」にもかかわらず、第3群の2～7番目の項目がいずれも「1.できる」")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを指定した場合_get名称は__聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、第3群の2～7番目の項目がいずれも_1.できる.get名称(), is(new RString("「聴力」が「5.判断不能」にもかかわらず、第3群の2～7番目の項目がいずれも「1.できる」")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_get名称は__聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できる.get名称(), is(new RString("「聴力」が「5.判断不能」にもかかわらず、「日常の意思決定」が「1.できる」")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_get名称は__視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_日常の意思決定_が_1.できる.get名称(), is(new RString("「視力」が「5.判断不能」にもかかわらず、「日常の意思決定」が「1.できる」")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を指定した場合_get名称は__聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_排便_が_1.自立.get名称(), is(new RString("「聴力」が「5.判断不能」にもかかわらず、「排便」が「1.自立」")));
    }

    @Test
    public void _意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_get名称は__意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._意思の伝達_が_4.できない_にもかかわらず、_日常の意思決定_が_1.できる.get名称(), is(new RString("「意思の伝達」が「4.できない」にもかかわらず、「日常の意思決定」が「1.できる」")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を指定した場合_get名称は__聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立.get名称(), is(new RString("「聴力」が「5.判断不能」にもかかわらず、「排尿」が「1.自立」")));
    }

    @Test
    public void _聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を指定した場合_get名称は__聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._聴力_が_5.判断不能_にもかかわらず、_移動_が_1.自立.get名称(), is(new RString("「聴力」が「5.判断不能」にもかかわらず、「移動」が「1.自立」")));
    }

    @Test
    public void _物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_get名称は__物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._物や衣類を壊す_が_3.ある_にもかかわらず、_日常の意思決定_が_1.できる.get名称(), is(new RString("「物や衣類を壊す」が「3.ある」にもかかわらず、「日常の意思決定」が「1.できる」")));
    }

    @Test
    public void _自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できるを指定した場合_get名称は__自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._自分の名前をいう_が_2.できない_にもかかわらず、_日常の意思決定_が_1.できる.get名称(), is(new RString("「自分の名前をいう」が「2.できない」にもかかわらず、「日常の意思決定」が「1.できる」")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を指定した場合_get名称は__視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_排便_が_1.自立.get名称(), is(new RString("「視力」が「5.判断不能」にもかかわらず、「排便」が「1.自立」")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を指定した場合_get名称は__視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_排尿_が_1.自立.get名称(), is(new RString("「視力」が「5.判断不能」にもかかわらず、「排尿」が「1.自立」")));
    }

    @Test
    public void _視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を指定した場合_get名称は__視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._視力_が_5.判断不能_にもかかわらず、_移動_が_1.自立.get名称(), is(new RString("「視力」が「5.判断不能」にもかかわらず、「移動」が「1.自立」")));
    }

    @Test
    public void _座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できるを指定した場合_get名称は__座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._座位保持_が_4.できない_にもかかわらず、_買い物_が_1.できる.get名称(), is(new RString("「座位保持」が「4.できない」にもかかわらず、「買い物」が「1.できる」")));
    }

    @Test
    public void _洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを指定した場合_get名称は__洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._洗顔_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できる.get名称(), is(new RString("「洗顔」が「3.全介助」にもかかわらず、「簡単な調理」が「1.できる」")));
    }

    @Test
    public void _整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを指定した場合_get名称は__整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._整髪_が_3.全介助_にもかかわらず、_簡単な調理_が_1.できる.get名称(), is(new RString("「整髪」が「3.全介助」にもかかわらず、「簡単な調理」が「1.できる」")));
    }

    @Test
    public void _金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できるを指定した場合_get名称は__金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._金銭の管理_が_3.全介助_にもかかわらず、_買い物_が_1.できる.get名称(), is(new RString("「金銭の管理」が「3.全介助」にもかかわらず、「買い物」が「1.できる」")));
    }

    @Test
    public void _日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できるを指定した場合_get名称は__日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._日常の意思決定_が_4.できない_にもかかわらず、_買い物_が_1.できる.get名称(), is(new RString("「日常の意思決定」が「4.できない」にもかかわらず、「買い物」が「1.できる」")));
    }

    @Test
    public void _意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できるを指定した場合_get名称は__意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._意思の伝達_が_4.できない_にもかかわらず、_買い物_が_1.できる.get名称(), is(new RString("「意思の伝達」が「4.できない」にもかかわらず、「買い物」が「1.できる」")));
    }

    @Test
    public void _物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ないを指定した場合_get名称は__物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ないを返す() {
        assertThat(IchijiHanteiKeikoku._物や衣類を壊す_が_3.ある_にもかかわらず、_自分勝手に行動する_が_1.ない.get名称(), is(new RString("「物や衣類を壊す」が「3.ある」にもかかわらず、「自分勝手に行動する」が「1.ない」")));
    }

    @Test
    public void _寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できるを指定した場合_get名称は__寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_起き上がり_が_1.できる.get名称(), is(new RString("「寝返り」が「3.できない」にもかかわらず、「起き上がり」が「1.できる」")));
    }

    @Test
    public void _寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_get名称は__寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._寝返り_が_3.できない_にもかかわらず、_立ち上がり_が_1.できる.get名称(), is(new RString("「寝返り」が「3.できない」にもかかわらず、「立ち上がり」が「1.できる」")));
    }

    @Test
    public void _起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できないを指定した場合_get名称は__起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できないを返す() {
        assertThat(IchijiHanteiKeikoku._起き上がり_が_1.できる_にもかかわらず、_座位保持_が_4.できない.get名称(), is(new RString("「起き上がり」が「1.できる」にもかかわらず、「座位保持」が「4.できない」")));
    }

    @Test
    public void _歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助を指定した場合_get名称は__歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku._歩行_が_1.できる_にもかかわらず、_移動_が_4.全介助.get名称(), is(new RString("「歩行」が「1.できる」にもかかわらず、「移動」が「4.全介助」")));
    }

    @Test
    public void _移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できるを指定した場合_get名称は__移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できるを返す() {
        assertThat(IchijiHanteiKeikoku._移乗_が_4.全介助_にもかかわらず、_立ち上がり_が_1.できる.get名称(), is(new RString("「移乗」が「4.全介助」にもかかわらず、「立ち上がり」が「1.できる」")));
    }

    @Test
    public void _洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助を指定した場合_get名称は__洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助を返す() {
        assertThat(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_洗顔_が_3.全介助.get名称(), is(new RString("「洗身」が「1.自立」にもかかわらず、「洗顔」が「3.全介助」")));
    }

    @Test
    public void _洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助を指定した場合_get名称は__洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_上衣の着脱_が_4.全介助.get名称(), is(new RString("「洗身」が「1.自立」にもかかわらず、「上衣の着脱」が「4.全介助」")));
    }

    @Test
    public void _洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助を指定した場合_get名称は__洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助を返す() {
        assertThat(IchijiHanteiKeikoku._洗身_が_1.自立_にもかかわらず、_ズボン等の着脱_が_4.全介助.get名称(), is(new RString("「洗身」が「1.自立」にもかかわらず、「ズボン等の着脱」が「4.全介助」")));
    }

    @Test
    public void _洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立を指定した場合_get名称は__洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._洗顔_が_3.全介助_にもかかわらず、_つめ切り_が_1.自立.get名称(), is(new RString("「洗顔」が「3.全介助」にもかかわらず、「つめ切り」が「1.自立」")));
    }

    @Test
    public void _つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能を指定した場合_get名称は__つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能を返す() {
        assertThat(IchijiHanteiKeikoku._つめ切り_が_1.自立_にもかかわらず、_視力_が_5.判断不能.get名称(), is(new RString("「つめ切り」が「1.自立」にもかかわらず、「視力」が「5.判断不能」")));
    }

    @Test
    public void _上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立を指定した場合_get名称は__上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立を返す() {
        assertThat(IchijiHanteiKeikoku._上衣の着脱_が_4.全介助_にもかかわらず、_ズボン等の着脱_が_1.自立.get名称(), is(new RString("「上衣の着脱」が「4.全介助」にもかかわらず、「ズボン等の着脱」が「1.自立」")));
    }

}
