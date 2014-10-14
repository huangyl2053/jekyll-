/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項定型文種別の列挙型です。
 *
 * @author n9606 漢那憲作
 */
public enum TeikeibunShubetsuTokki implements IRStringConvertable {

    /**
     * 第１群_１_麻痺 ("001")
     */
    第１群_１_麻痺(new RString("001")),
    /**
     * 第１群_２_拘縮 ("002")
     */
    第１群_２_拘縮(new RString("002")),
    /**
     * 第１群_３_寝返り ("003")
     */
    第１群_３_寝返り(new RString("003")),
    /**
     * 第１群_４_起き上がり ("004")
     */
    第１群_４_起き上がり(new RString("004")),
    /**
     * 第１群_５_座位保持 ("005")
     */
    第１群_５_座位保持(new RString("005")),
    /**
     * 第１群_６_両足での立位 ("006")
     */
    第１群_６_両足での立位(new RString("006")),
    /**
     * 第１群_７_歩行 ("007")
     */
    第１群_７_歩行(new RString("007")),
    /**
     * 第１群_８_立ち上がり ("008")
     */
    第１群_８_立ち上がり(new RString("008")),
    /**
     * 第１群_９_片足での立位 ("009")
     */
    第１群_９_片足での立位(new RString("009")),
    /**
     * 第１群_１０_洗身 ("010")
     */
    第１群_１０_洗身(new RString("010")),
    /**
     * 第１群_１１_つめ切り ("011")
     */
    第１群_１１_つめ切り(new RString("011")),
    /**
     * 第１群_１２_視力 ("012")
     */
    第１群_１２_視力(new RString("012")),
    /**
     * 第１群_１３_聴力 ("013")
     */
    第１群_１３_聴力(new RString("013")),
    /**
     * 第２群_１_移乗 ("014")
     */
    第２群_１_移乗(new RString("014")),
    /**
     * 第２群_２_移動 ("015")
     */
    第２群_２_移動(new RString("015")),
    /**
     * 第２群_３_えん下 ("016")
     */
    第２群_３_えん下(new RString("016")),
    /**
     * 第２群_４_食事摂取 ("017")
     */
    第２群_４_食事摂取(new RString("017")),
    /**
     * 第２群_５_排尿 ("018")
     */
    第２群_５_排尿(new RString("018")),
    /**
     * 第２群_６_排便 ("019")
     */
    第２群_６_排便(new RString("019")),
    /**
     * 第２群_７_口腔清潔 ("020")
     */
    第２群_７_口腔清潔(new RString("020")),
    /**
     * 第２群_８_洗顔 ("021")
     */
    第２群_８_洗顔(new RString("021")),
    /**
     * 第２群_９_整髪 ("022")
     */
    第２群_９_整髪(new RString("022")),
    /**
     * 第２群_１０_上衣の着脱 ("023")
     */
    第２群_１０_上衣の着脱(new RString("023")),
    /**
     * 第２群_１１_ズボン等の着脱 ("024")
     */
    第２群_１１_ズボン等の着脱(new RString("024")),
    /**
     * 第２群_１２_外出頻度 ("025")
     */
    第２群_１２_外出頻度(new RString("025")),
    /**
     * 第３群_１_意思の伝達 ("026")
     */
    第３群_１_意思の伝達(new RString("026")),
    /**
     * 第３群_２_毎日の日課を理解 ("027")
     */
    第３群_２_毎日の日課を理解(new RString("027")),
    /**
     * 第３群_３_生年月日をいう ("028")
     */
    第３群_３_生年月日をいう(new RString("028")),
    /**
     * 第３群_４_短期記憶 ("029")
     */
    第３群_４_短期記憶(new RString("029")),
    /**
     * 第３群_５_自分の名前をいう ("030")
     */
    第３群_５_自分の名前をいう(new RString("030")),
    /**
     * 第３群_６_今の季節を理解 ("031")
     */
    第３群_６_今の季節を理解(new RString("031")),
    /**
     * 第３群_７_場所の理解 ("032")
     */
    第３群_７_場所の理解(new RString("032")),
    /**
     * 第３群_８_徘徊 ("033")
     */
    第３群_８_徘徊(new RString("033")),
    /**
     * 第３群_９_外出して戻れない ("034")
     */
    第３群_９_外出して戻れない(new RString("034")),
    /**
     * 第４群_１_被害的 ("035")
     */
    第４群_１_被害的(new RString("035")),
    /**
     * 第４群_２_作話 ("036")
     */
    第４群_２_作話(new RString("036")),
    /**
     * 第４群_３_感情が不安定 ("037")
     */
    第４群_３_感情が不安定(new RString("037")),
    /**
     * 第４群_４_昼夜逆転 ("038")
     */
    第４群_４_昼夜逆転(new RString("038")),
    /**
     * 第４群_５_同じ話をする ("039")
     */
    第４群_５_同じ話をする(new RString("039")),
    /**
     * 第４群_６_大声を出す ("040")
     */
    第４群_６_大声を出す(new RString("040")),
    /**
     * 第４群_７_介護に抵抗 ("041")
     */
    第４群_７_介護に抵抗(new RString("041")),
    /**
     * 第４群_８_落ち着きなし ("042")
     */
    第４群_８_落ち着きなし(new RString("042")),
    /**
     * 第４群_９_一人で出たがる ("043")
     */
    第４群_９_一人で出たがる(new RString("043")),
    /**
     * 第４群_１０_収集癖 ("044")
     */
    第４群_１０_収集癖(new RString("044")),
    /**
     * 第４群_１１_物や衣類を壊す ("045")
     */
    第４群_１１_物や衣類を壊す(new RString("045")),
    /**
     * 第４群_１２_ひどい物忘れ ("046")
     */
    第４群_１２_ひどい物忘れ(new RString("046")),
    /**
     * 第４群_１３_独り言独り笑い ("047")
     */
    第４群_１３_独り言独り笑い(new RString("047")),
    /**
     * 第４群_１４_自分勝手に行動する ("048")
     */
    第４群_１４_自分勝手に行動する(new RString("048")),
    /**
     * 第４群_１５_話がまとまらない ("049")
     */
    第４群_１５_話がまとまらない(new RString("049")),
    /**
     * 第５群_１_薬の内服 ("050")
     */
    第５群_１_薬の内服(new RString("050")),
    /**
     * 第５群_２_金銭の管理 ("051")
     */
    第５群_２_金銭の管理(new RString("051")),
    /**
     * 第５群_３_日常の意思決定 ("052")
     */
    第５群_３_日常の意思決定(new RString("052")),
    /**
     * 第５群_４_集団への不適応 ("053")
     */
    第５群_４_集団への不適応(new RString("053")),
    /**
     * 第５群_５_買い物 ("054")
     */
    第５群_５_買い物(new RString("054")),
    /**
     * 第５群_６_簡単な調理 ("055")
     */
    第５群_６_簡単な調理(new RString("055")),
    /**
     * 特別な医療_点滴の管理 ("056")
     */
    特別な医療_点滴の管理(new RString("056")),
    /**
     * 特別な医療_中心静脈栄養 ("057")
     */
    特別な医療_中心静脈栄養(new RString("057")),
    /**
     * 特別な医療_透析 ("058")
     */
    特別な医療_透析(new RString("058")),
    /**
     * 特別な医療_ストーマの処置 ("059")
     */
    特別な医療_ストーマの処置(new RString("059")),
    /**
     * 特別な医療_酸素療法 ("060")
     */
    特別な医療_酸素療法(new RString("060")),
    /**
     * 特別な医療_レスピレーター ("061")
     */
    特別な医療_レスピレーター(new RString("061")),
    /**
     * 特別な医療_気管切開の処置 ("062")
     */
    特別な医療_気管切開の処置(new RString("062")),
    /**
     * 特別な医療_疼痛の看護 ("063")
     */
    特別な医療_疼痛の看護(new RString("063")),
    /**
     * 特別な医療_経管栄養 ("064")
     */
    特別な医療_経管栄養(new RString("064")),
    /**
     * 特別な医療_モニター測定 ("065")
     */
    特別な医療_モニター測定(new RString("065")),
    /**
     * 特別な医療_じょくそうの処置 ("066")
     */
    特別な医療_じょくそうの処置(new RString("066")),
    /**
     * 特別な医療_カテーテル ("067")
     */
    特別な医療_カテーテル(new RString("067")),
    /**
     * 日常生活自立度_寝たきり度 ("068")
     */
    日常生活自立度_寝たきり度(new RString("068")),
    /**
     * 日常生活自立度_認知症高齢者 ("069")
     */
    日常生活自立度_認知症高齢者(new RString("069")),
    /**
     * その他特記 ("070")
     */
    その他特記(new RString("070"));
    private final RString code;

    private TeikeibunShubetsuTokki(RString code) {
        this.code = code;
    }

    /**
     * 指定された特記事項の定型文種別コードに該当する定型文種別を返します。
     *
     * @param code 定型文種別コード
     * @return 引数のコードに対応するTeikeibunShubetsu型のenum
     * @throws IllegalArgumentException 実在しない定型文種別コードの場合
     */
    public static TeikeibunShubetsuTokki toValue(RString code) throws NullPointerException, IllegalArgumentException {

        for (TeikeibunShubetsuTokki item : TeikeibunShubetsuTokki.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("該当する定型文種別").getMessage());
    }

    /**
     * 定型文種別を返します。
     *
     * @return 定型文種別コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
