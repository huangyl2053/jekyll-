package jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）を表す列挙型です。
 *
 */
public enum NinteichosaSoshinIfMapping09A {

    /**
     * コード:110 名称:麻痺等の有無（左上肢） 略称:定義なし
     */
    麻痺等_左上肢("110", "麻痺等の有無（左上肢）"),
    /**
     * コード:111 名称:麻痺等の有無（右上肢） 略称:定義なし
     */
    麻痺等_右上肢("111", "麻痺等の有無（右上肢）"),
    /**
     * コード:112 名称:麻痺等の有無（左下肢） 略称:定義なし
     */
    麻痺等_左下肢("112", "麻痺等の有無（左下肢）"),
    /**
     * コード:113 名称:麻痺等の有無（右下肢） 略称:定義なし
     */
    麻痺等_右下肢("113", "麻痺等の有無（右下肢）"),
    /**
     * コード:114 名称:麻痺等の有無（その他） 略称:定義なし
     */
    麻痺等_その他("114", "麻痺等の有無（その他）"),
    /**
     * コード:115 名称:拘縮の有無（肩関節） 略称:定義なし
     */
    拘縮_肩関節("115", "拘縮の有無（肩関節）"),
    /**
     * コード:116 名称:拘縮の有無（股関節） 略称:定義なし
     */
    拘縮_股関節("116", "拘縮の有無（股関節）"),
    /**
     * コード:117 名称:拘縮の有無（膝関節） 略称:定義なし
     */
    拘縮_膝関節("117", "拘縮の有無（膝関節）"),
    /**
     * コード:118 名称:拘縮の有無（その他） 略称:定義なし
     */
    拘縮_その他("118", "拘縮の有無（その他）"),
    /**
     * コード:119 名称:寝返り 略称:定義なし
     */
    寝返り("119", "寝返り"),
    /**
     * コード:120 名称:起き上がり 略称:定義なし
     */
    起き上がり("120", "起き上がり"),
    /**
     * コード:121 名称:座位保持 略称:定義なし
     */
    座位保持("121", "座位保持"),
    /**
     * コード:122 名称:両足での立位 略称:定義なし
     */
    両足での立位("122", "両足での立位"),
    /**
     * コード:123 名称:歩行 略称:定義なし
     */
    歩行("123", "歩行"),
    /**
     * コード:124 名称:立ち上がり 略称:定義なし
     */
    立ち上がり("124", "立ち上がり"),
    /**
     * コード:125 名称:片足での立位 略称:定義なし
     */
    片足での立位("125", "片足での立位"),
    /**
     * コード:126 名称:洗身 略称:定義なし
     */
    洗身("126", "洗身"),
    /**
     * コード:127 名称:つめ切り 略称:定義なし
     */
    つめ切り("127", "つめ切り"),
    /**
     * コード:128 名称:視力 略称:定義なし
     */
    視力("128", "視力"),
    /**
     * コード:129 名称:聴力 略称:定義なし
     */
    聴力("129", "聴力"),
    /**
     * コード:130 名称:移乗 略称:定義なし
     */
    移乗("130", "移乗"),
    /**
     * コード:131 名称:移動 略称:定義なし
     */
    移動("131", "移動"),
    /**
     * コード:132 名称:嚥下 略称:定義なし
     */
    嚥下("132", "嚥下"),
    /**
     * コード:133 名称:食事摂取 略称:定義なし
     */
    食事摂取("133", "食事摂取"),
    /**
     * コード:134 名称:排尿 略称:定義なし
     */
    排尿("134", "排尿"),
    /**
     * コード:135 名称:排便 略称:定義なし
     */
    排便("135", "排便"),
    /**
     * コード:136 名称:口腔清潔 略称:定義なし
     */
    口腔清潔("136", "口腔清潔"),
    /**
     * コード:137 名称:洗顔 略称:定義なし
     */
    洗顔("137", "洗顔"),
    /**
     * コード:138 名称:整髪 略称:定義なし
     */
    整髪("138", "整髪"),
    /**
     * コード:139 名称:上衣の着脱 略称:定義なし
     */
    上衣の着脱("139", "上衣の着脱"),
    /**
     * コード:140 名称:ズボン等の着脱 略称:定義なし
     */
    ズボン等の着脱("140", "ズボン等の着脱"),
    /**
     * コード:141 名称:外出頻度 略称:定義なし
     */
    外出頻度("141", "外出頻度"),
    /**
     * コード:142 名称:意思の伝達 略称:定義なし
     */
    意思の伝達("142", "意思の伝達"),
    /**
     * コード:143 名称:毎日の日課を理解 略称:定義なし
     */
    毎日の日課を理解("143", "毎日の日課を理解"),
    /**
     * コード:144 名称:生年月日をいう 略称:定義なし
     */
    生年月日をいう("144", "生年月日をいう"),
    /**
     * コード:145 名称:短期記憶 略称:定義なし
     */
    短期記憶("145", "短期記憶"),
    /**
     * コード:146 名称:自分の名前をいう 略称:定義なし
     */
    自分の名前をいう("146", "自分の名前をいう"),
    /**
     * コード:147 名称:今の季節を理解 略称:定義なし
     */
    今の季節を理解("147", "今の季節を理解"),
    /**
     * コード:148 名称:場所の理解 略称:定義なし
     */
    場所の理解("148", "場所の理解"),
    /**
     * コード:149 名称:常時の徘徊 略称:定義なし
     */
    常時の徘徊("149", "常時の徘徊"),
    /**
     * コード:150 名称:外出して戻れない 略称:定義なし
     */
    外出して戻れない("150", "外出して戻れない"),
    /**
     * コード:151 名称:被害的 略称:定義なし
     */
    被害的("151", "被害的"),
    /**
     * コード:152 名称:作話 略称:定義なし
     */
    作話("152", "作話"),
    /**
     * コード:153 名称:感情が不安定 略称:定義なし
     */
    感情が不安定("153", "感情が不安定"),
    /**
     * コード:154 名称:昼夜逆転 略称:定義なし
     */
    昼夜逆転("154", "昼夜逆転"),
    /**
     * コード:155 名称:同じ話をする 略称:定義なし
     */
    同じ話をする("155", "同じ話をする"),
    /**
     * コード:156 名称:大声を出す 略称:定義なし
     */
    大声を出す("156", "大声を出す"),
    /**
     * コード:157 名称:介護に抵抗 略称:定義なし
     */
    介護に抵抗("157", "介護に抵抗"),
    /**
     * コード:158 名称:落ち着きなし 略称:定義なし
     */
    落ち着きなし("158", "落ち着きなし"),
    /**
     * コード:159 名称:一人で出たがる 略称:定義なし
     */
    一人で出たがる("159", "一人で出たがる"),
    /**
     * コード:160 名称:収集癖 略称:定義なし
     */
    収集癖("160", "収集癖"),
    /**
     * コード:161 名称:物や衣類を壊す 略称:定義なし
     */
    物や衣類を壊す("161", "物や衣類を壊す"),
    /**
     * コード:162 名称:ひどい物忘れ 略称:定義なし
     */
    ひどい物忘れ("162", "ひどい物忘れ"),
    /**
     * コード:163 名称:独り言・独り笑い 略称:定義なし
     */
    独り言_独り笑い("163", "独り言・独り笑い"),
    /**
     * コード:164 名称:自分勝手に行動する 略称:定義なし
     */
    自分勝手に行動する("164", "自分勝手に行動する"),
    /**
     * コード:165 名称:話がまとまらない 略称:定義なし
     */
    話がまとまらない("165", "話がまとまらない"),
    /**
     * コード:166 名称:薬の内服 略称:定義なし
     */
    薬の内服("166", "薬の内服"),
    /**
     * コード:167 名称:金銭の管理 略称:定義なし
     */
    金銭の管理("167", "金銭の管理"),
    /**
     * コード:168 名称:日常の意思決定 略称:定義なし
     */
    日常の意思決定("168", "日常の意思決定"),
    /**
     * コード:169 名称:集団への不適応 略称:定義なし
     */
    集団への不適応("169", "集団への不適応"),
    /**
     * コード:170 名称:買い物 略称:定義なし
     */
    買い物("170", "買い物"),
    /**
     * コード:171 名称:簡単な調理 略称:定義なし
     */
    簡単な調理("171", "簡単な調理"),
    /**
     * コード:172 名称:処置内容（点滴の管理） 略称:定義なし
     */
    点滴の管理("172", "処置内容（点滴の管理）"),
    /**
     * コード:173 名称:処置内容（中心静脈栄養） 略称:定義なし
     */
    中心静脈栄養("173", "処置内容（中心静脈栄養）"),
    /**
     * コード:174 名称:処置内容（透析） 略称:定義なし
     */
    透析("174", "処置内容（透析）"),
    /**
     * コード:175 名称:処置内容（ストーマの処置） 略称:定義なし
     */
    ストーマの処置("175", "処置内容（ストーマの処置）"),
    /**
     * コード:176 名称:処置内容（酸素療法） 略称:定義なし
     */
    酸素療法("176", "処置内容（酸素療法）"),
    /**
     * コード:177 名称:処置内容（レスピレーター） 略称:定義なし
     */
    レスピレーター("177", "処置内容（レスピレーター）"),
    /**
     * コード:178 名称:処置内容（気管切開の処置） 略称:定義なし
     */
    気管切開の処置("178", "処置内容（気管切開の処置）"),
    /**
     * コード:179 名称:処置内容（疼痛の看護） 略称:定義なし
     */
    疼痛の看護("179", "処置内容（疼痛の看護）"),
    /**
     * コード:180 名称:処置内容（経管栄養） 略称:定義なし
     */
    経管栄養("180", "処置内容（経管栄養）"),
    /**
     * コード:181 名称:特別な対応（モニター測定） 略称:定義なし
     */
    モニター測定("181", "特別な対応（モニター測定）"),
    /**
     * コード:182 名称:特別な対応（じょくそうの処置） 略称:定義なし
     */
    じょくそうの処置("182", "特別な対応（じょくそうの処置）"),
    /**
     * コード:183 名称:失禁への対応（カテーテル） 略称:定義なし
     */
    カテーテル("183", "失禁への対応（カテーテル）");

    private final RString code;
    private final RString fullName;

    private NinteichosaSoshinIfMapping09A(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）のコードを返します。
     *
     * @return 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）の名称を返します。
     *
     * @return 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）のコードと一致する内容を探します。
     *
     * @param code 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）のコード
     * @return {@code code} に対応する認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）
     */
    public static NinteichosaSoshinIfMapping09A toValue(RString code) {
        for (NinteichosaSoshinIfMapping09A ninteichosaSoshinIfMapping09A : NinteichosaSoshinIfMapping09A.values()) {
            if (ninteichosaSoshinIfMapping09A.code.equals(code)) {
                return ninteichosaSoshinIfMapping09A;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage(" 認定調査票09A（厚労省IF連携フォーマット_データ送信_項番）"));
    }
}
