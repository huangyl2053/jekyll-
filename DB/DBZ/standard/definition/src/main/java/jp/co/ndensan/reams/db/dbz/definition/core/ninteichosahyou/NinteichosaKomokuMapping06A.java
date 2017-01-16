package jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票06Aを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum NinteichosaKomokuMapping06A implements INinteichosaKomokuMapping {

    /**
     * コード:1 名称:麻痺等の有無（左上肢） 表示番号:1-1-1 パターンNo:1 特記事項番号:101 略称:定義なし
     */
    麻痺等_左上肢("1", "麻痺等の有無（左上肢）", "1-1-1", "1", "101"),
    /**
     * コード:2 名称:麻痺等の有無（右上肢） 表示番号:1-1-2 パターンNo:1 特記事項番号:101 略称:定義なし
     */
    麻痺等_右上肢("2", "麻痺等の有無（右上肢）", "1-1-2", "1", "101"),
    /**
     * コード:3 名称:麻痺等の有無（左下肢） 表示番号:1-1-3 パターンNo:1 特記事項番号:101 略称:定義なし
     */
    麻痺等_左下肢("3", "麻痺等の有無（左下肢）", "1-1-3", "1", "101"),
    /**
     * コード:4 名称:麻痺等の有無（右下肢） 表示番号:1-1-4 パターンNo:1 特記事項番号:101 略称:定義なし
     */
    麻痺等_右下肢("4", "麻痺等の有無（右下肢）", "1-1-4", "1", "101"),
    /**
     * コード:5 名称:麻痺等の有無（その他） 表示番号:1-1-5 パターンNo:1 特記事項番号:101 略称:定義なし
     */
    麻痺等_その他("5", "麻痺等の有無（その他）", "1-1-5", "1", "101"),
    /**
     * コード:6 名称:関節の動く範囲の制限（肩関節） 表示番号:1-2-1 パターンNo:1 特記事項番号:102 略称:定義なし
     */
    拘縮_肩関節("6", "関節の動く範囲の制限（肩関節）", "1-2-1", "1", "102"),
    /**
     * コード:7 名称:関節の動く範囲の制限（肘関節） 表示番号:1-2-2 パターンNo:1 特記事項番号:102 略称:定義なし
     */
    拘縮_肘関節("7", "関節の動く範囲の制限（肘関節）", "1-2-2", "1", "102"),
    /**
     * コード:8 名称:関節の動く範囲の制限（股関節） 表示番号:1-2-3 パターンNo:1 特記事項番号:102 略称:定義なし
     */
    拘縮_股関節("8", "関節の動く範囲の制限（股関節）", "1-2-3", "1", "102"),
    /**
     * コード:9 名称:関節の動く範囲の制限（膝関節） 表示番号:1-2-4 パターンNo:1 特記事項番号:102 略称:定義なし
     */
    拘縮_膝関節("9", "関節の動く範囲の制限（膝関節）", "1-2-4", "1", "102"),
    /**
     * コード:10 名称:関節の動く範囲の制限（足関節） 表示番号:1-2-5 パターンNo:1 特記事項番号:102 略称:定義なし
     */
    拘縮_足関節("10", "関節の動く範囲の制限（足関節）", "1-2-5", "1", "102"),
    /**
     * コード:11 名称:関節の動く範囲の制限（その他） 表示番号:1-2-6 パターンNo:1 特記事項番号:102 略称:定義なし
     */
    拘縮_その他("11", "関節の動く範囲の制限（その他）", "1-2-6", "1", "102"),
    /**
     * コード:12 名称:寝返り 表示番号:2-1 パターンNo:2 特記事項番号:201 略称:定義なし
     */
    寝返り("12", "寝返り", "2-1", "2", "201"),
    /**
     * コード:13 名称:起き上がり表示番号:2-2 パターンNo:2 特記事項番号:202 略称:定義なし
     */
    起き上がり("13", "起き上がり", "2-2", "2", "202"),
    /**
     * コード:14 名称:座位保持 表示番号:2-3 パターンNo:3 特記事項番号:203 略称:定義なし
     */
    座位保持("14", "座位保持", "2-3", "3", "203"),
    /**
     * コード:15 名称:両足での立位 表示番号:2-4 パターンNo:3 特記事項番号:204 略称:定義なし
     */
    両足での立位("15", "両足での立位", "2-4", "3", "204"),
    /**
     * コード:16 名称:歩行 表示番号:2-5 パターンNo:4 特記事項番号:205 略称:定義なし
     */
    歩行("16", "歩行", "2-5", "4", "205"),
    /**
     * コード:17 名称:移乗 表示番号:2-6 パターンNo:2 特記事項番号:206 略称:定義なしし
     */
    移乗("17", "移乗", "2-6", "20", "206"),
    /**
     * コード:18 名称:移動 表示番号:2-7 パターンNo:20 特記事項番号:207 略称:定義なし
     */
    移動("18", "移動", "2-7", "20", "207"),
    /**
     * コード:19 名称:立ち上がり 表示番号:3-1 パターンNo:2 特記事項番号:301 略称:定義なし
     */
    立ち上がり("19", "立ち上がり", "3-1", "2", "301"),
    /**
     * コード:20 名称:片足での立位 表示番号:3-2 パターンNo:4 特記事項番号:302 略称:定義なし
     */
    片足での立位("20", "片足での立位", "3-2", "4", "302"),
    /**
     * コード:21 名称:洗身 表示番号:3-3 パターンNo:21 特記事項番号:303 略称:定義なし
     */
    洗身("21", "洗身", "3-3", "21", "303"),
    /**
     * コード:22 名称:じょくそう 表示番号:4-1-ｱ パターンNo:1 特記事項番号:401 略称:定義なし
     */
    じょくそう("22", "じょくそう", "4-1-ｱ", "1", "401"),
    /**
     * コード:23 名称:他の皮膚疾患 表示番号:4-1-ｲ パターンNo:1 特記事項番号:401 略称:定義なし
     */
    他の皮膚疾患("23", "他の皮膚疾患", "4-1-ｲ", "1", "401"),
    /**
     * コード:24 名称:嚥下表示番号:4-2 パターンNo:30 特記事項番号:402 略称:定義なし
     */
    えん下("24", "嚥下", "4-2", "30", "402"),
    /**
     * コード:25 名称:食事摂取 表示番号:4-3 パターンNo:31 特記事項番号:403 略称:定義なし
     */
    食事摂取("25", "食事摂取", "4-3", "31", "403"),
    /**
     * コード:26 名称:飲水 表示番号:4-4 パターンNo:16 特記事項番号:404 略称:定義なし
     */
    飲水("26", "飲水", "4-4", "16", "404"),
    /**
     * コード:27 名称:排尿 表示番号:4-5 パターンNo:32 特記事項番号:405 略称:定義なし
     */
    排尿("27", "排尿", "4-5", "32", "405"),
    /**
     * コード:28 名称:排便 表示番号:4-6 パターンNo:32 特記事項番号:406 略称:定義なし
     */
    排便("28", "排便", "4-6", "32", "406"),
    /**
     * コード:29 名称:口腔清潔 表示番号:5-1-ｱ パターンNo:22 特記事項番号:501 略称:定義なし
     */
    口腔清潔("29", "口腔清潔", "5-1-ｱ", "22", "501"),
    /**
     * コード:30 名称:洗顔 表示番号:5-1-ｲ パターンNo:22 特記事項番号:501 略称:定義なし
     */
    洗顔("30", "洗顔", "5-1-ｲ", "22", "501"),
    /**
     * コード:31 名称:整髪 表示番号:5-1-ｳ パターンNo:22 特記事項番号:501 略称:定義なし
     */
    整髪("31", "整髪", "5-1-ｳ", "22", "501"),
    /**
     * コード:32 名称:つめ切り 表示番号:5-1-ｴ パターンNo:22 特記事項番号:501 略称:定義なし
     */
    つめ切り("32", "つめ切り", "5-1-ｴ", "22", "501"),
    /**
     * コード:33 名称:上衣の着脱 表示番号:5-2-ｱ パターンNo:34 特記事項番号:502 略称:定義なし
     */
    上衣の着脱("33", "上衣の着脱", "5-2-ｱ", "34", "502"),
    /**
     * コード:34 名称:ズボン、パンツ等の着脱 表示番号:5-2-ｲ パターンNo:34 特記事項番号:502 略称:定義なし
     */
    ズボン等の着脱("34", "ズボン、パンツ等の着脱", "5-2-ｲ", "34", "502"),
    /**
     * コード:35 名称:薬の内服 表示番号:5-3 パターンNo:22 特記事項番号:503 略称:定義なし
     */
    薬の内服("35", "薬の内服", "5-3", "22", "503"),
    /**
     * コード:36 名称:金銭の管理 表示番号:5-4 パターンNo:22 特記事項番号:504 略称:定義なし
     */
    金銭の管理("36", "金銭の管理", "5-4", "22", "504"),
    /**
     * コード:37 名称:電話の利用 表示番号:5-5 パターンNo:22 特記事項番号:505 略称:定義なし
     */
    電話の利用("37", "電話の利用", "5-5", "22", "505"),
    /**
     * コード:38 名称:日常の意思決定 表示番号:5-6 パターンNo:17 特記事項番号:506 略称:定義なし
     */
    日常の意思決定("38", "日常の意思決定", "5-6", "17", "506"),
    /**
     * コード:39 名称:視力 表示番号:6-1 パターンNo:8 特記事項番号:601 略称:定義なし
     */
    視力("39", "視力", "6-1", "8", "601"),
    /**
     * コード:40 名称:聴力 表示番号:6-2 パターンNo:9 特記事項番号:602 略称:定義なし
     */
    聴力("40", "聴力", "6-2", "9", "602"),
    /**
     * コード:41 名称:意思の伝達 表示番号:6-3 パターンNo:14 特記事項番号:603 略称:定義なし
     */
    意思の伝達("41", "意思の伝達", "6-3", "14", "603"),
    /**
     * コード:42 名称:介護者の指示への反応 表示番号:6-4 パターンNo:23 特記事項番号:604 略称:定義なし
     */
    指示への反応("42", "介護者の指示への反応", "6-4", "23", "604"),
    /**
     * コード:43 名称:毎日の日課を理解 表示番号:6-5-ｱ パターンNo:15 特記事項番号:605 略称:定義なし
     */
    毎日の日課を理解("43", "毎日の日課を理解", "6-5-ｱ", "15", "605"),
    /**
     * コード:44 名称:生年月日をいう 表示番号:6-5-ｲ パターンNo:15 特記事項番号:605 略称:定義なし
     */
    生年月日をいう("44", "生年月日をいう", "6-5-ｲ", "15", "605"),
    /**
     * コード:45 名称:短期記憶 表示番号:6-5-ｳ パターンNo:15 特記事項番号:605 略称:定義なし
     */
    短期記憶("45", "短期記憶", "6-5-ｳ", "15", "605"),
    /**
     * コード:46 名称:自分の名前をいう 表示番号:6-5-ｴ パターンNo:15 特記事項番号:605 略称:定義なし
     */
    自分の名前をいう("46", "自分の名前をいう", "6-5-ｴ", "15", "605"),
    /**
     * コード:47 名称:今の季節を理解 表示番号:6-5-ｵ パターンNo:15 特記事項番号:605 略称:定義なし
     */
    今の季節を理解("47", "今の季節を理解", "6-5-ｵ", "15", "605"),
    /**
     * コード:48 名称:場所の理解 表示番号:6-5-ｶ パターンNo:15 特記事項番号:605 略称:定義なし
     */
    場所の理解("48", "場所の理解", "6-5-ｶ ", "15", "605"),
    /**
     * コード:49 名称:被害的 表示番号:7-ｱ パターンNo:16 特記事項番号:701 略称:定義なし
     */
    被害的("49", "被害的", "7-ｱ", "16", "701"),
    /**
     * コード:50 名称:作話 表示番号:7-ｲ パターンNo:16 特記事項番号:702 略称:定義なし
     */
    作話("50", "作話", "7-ｲ", "16", "702"),
    /**
     * コード:51 名称:幻視幻聴 表示番号:7-ｳ パターンNo:16 特記事項番号:703 略称:定義なし
     */
    幻視幻聴("51", "幻視幻聴", "7-ｳ", "16", "703"),
    /**
     * コード:52 名称:感情が不安定 表示番号:7-ｴ パターンNo:16 特記事項番号:704 略称:定義なし
     */
    感情が不安定("52", "感情が不安定", "7-ｴ", "16", "704"),
    /**
     * コード:53 名称:昼夜逆転 表示番号:7-ｵ パターンNo:16 特記事項番号:705 略称:定義なし
     */
    昼夜逆転("53", "昼夜逆転", "7-ｵ", "16", "705"),
    /**
     * コード:54 名称:暴言暴行 表示番号:7-ｶ パターンNo:16 特記事項番号:706 略称:定義なし
     */
    暴言暴行("54", "暴言暴行", "7-ｶ", "16", "706"),
    /**
     * コード:55 名称:同じ話をする 表示番号:7-ｷ パターンNo:16 特記事項番号:707 略称:定義なし
     */
    同じ話をする("55", "同じ話をする", "7-ｷ", "16", "707"),
    /**
     * コード:56 名称:大声をだす 表示番号:7-ｸ パターンNo:16 特記事項番号:708 略称:定義なし
     */
    大声をだす("56", "大声をだす", "7-ｸ", "16", "708"),
    /**
     * コード:57 名称:介護に抵抗 表示番号:7-ｹ パターンNo:16 特記事項番号:709 略称:定義なし
     */
    介護に抵抗("57", "介護に抵抗", "7-ｹ", "16", "709"),
    /**
     * コード:58 名称:常時の徘徊 表示番号:7-ｺ パターンNo:16 特記事項番号:710 略称:定義なし
     */
    常時の徘徊("58", "常時の徘徊", "7-ｺ", "16", "710"),
    /**
     * コード:59 名称:落ち着きなし 表示番号:7-ｻ パターンNo:16 特記事項番号:711 略称:定義なし
     */
    落ち着きなし("59", "落ち着きなし", "7-ｻ", "16", "711"),
    /**
     * コード:60 名称:外出して戻れない 表示番号:7-ｼ パターンNo:16 特記事項番号:712 略称:定義なし
     */
    外出して戻れない("60", "外出して戻れない", "7-ｼ", "16", "712"),
    /**
     * コード:61 名称:一人で出たがる 表示番号:7-ｽ パターンNo:16 特記事項番号:713 略称:定義なし
     */
    一人で出たがる("61", "一人で出たがる", "7-ｽ", "16", "713"),
    /**
     * コード:62 名称:収集癖 表示番号:7-ｾ パターンNo:16 特記事項番号:714 略称:定義なし
     */
    収集癖("62", "収集癖", "7-ｾ", "16", "714"),
    /**
     * コード:63 名称:火の不始末表示番号:7-ｿ パターンNo:16 特記事項番号:715 略称:定義なし
     */
    火の不始末("63", "火の不始末", "7-ｿ", "16", "715"),
    /**
     * コード:64 名称:物や衣類を壊す 表示番号:7-ﾀ パターンNo:16 特記事項番号:716 略称:定義なし
     */
    物や衣類を壊す("64", "物や衣類を壊す", "7-ﾀ", "16", "716"),
    /**
     * コード:65 名称:不潔行為 表示番号:7-ﾁ パターンNo:16 特記事項番号:717 略称:定義なし
     */
    不潔行為("65", "不潔行為", "7-ﾁ", "16", "717"),
    /**
     * コード:66 名称:異食行動 表示番号:7-ﾂ パターンNo:16 特記事項番号:718 略称:定義なし
     */
    異食行動("66", "異食行動", "7-ﾂ", "16", "718"),
    /**
     * コード:67 名称:ひどい物忘れ 表示番号:7-ﾃ パターンNo:16 特記事項番号:719 略称:定義なし
     */
    ひどい物忘れ("67", "ひどい物忘れ", "7-ﾃ", "16", "719"),
    /**
     * コード:68 名称:処置内容（点滴の管理） 表示番号:特医-1 パターンNo:1 特記事項番号:801 略称:定義なし
     */
    点滴の管理("68", "処置内容（点滴の管理）", "特医-1", "1", "801"),
    /**
     * コード:69 名称:処置内容（中心静脈栄養） 表示番号:特医-2 パターンNo:1 特記事項番号:802 略称:定義なし
     */
    中心静脈栄養("69", "処置内容（中心静脈栄養）", "特医-2", "1", "802"),
    /**
     * コード:70 名称:処置内容（透析） 表示番号:特医-3 パターンNo:1 特記事項番号:803 略称:定義なし
     */
    透析("70", "処置内容（透析）", "特医-3", "1", "803"),
    /**
     * コード:71 名称:処置内容（ストーマの処置） 表示番号:特医-4 パターンNo:1 特記事項番号:804 略称:定義なし
     */
    ストーマの処置("71", "処置内容（ストーマの処置）", "特医-4", "1", "804"),
    /**
     * コード:72 名称:処置内容（酸素療法） 表示番号:特医-5 パターンNo:1 特記事項番号:805 略称:定義なし
     */
    酸素療法("72", "処置内容（酸素療法）", "特医-5", "1", "805"),
    /**
     * コード:73 名称:処置内容（レスピレーター） 表示番号:特医-6 パターンNo:1 特記事項番号:806 略称:定義なし
     */
    レスピレーター("73", "処置内容（レスピレーター）", "特医-6", "1", "806"),
    /**
     * コード:74 名称:処置内容（気管切開の処置） 表示番号:特医-7 パターンNo:1 特記事項番号:807 略称:定義なし
     */
    気管切開の処置("74", "処置内容（気管切開の処置）", "特医-7", "1", "807"),
    /**
     * コード:75 名称:処置内容（疼痛の看護） 表示番号:特医-8 パターンNo:1 特記事項番号:808 略称:定義なし
     */
    疼痛の看護("75", "処置内容（疼痛の看護）", "特医-8", "1", "808"),
    /**
     * コード:76 名称:処置内容（経管栄養） 表示番号:特医-9 パターンNo:1 特記事項番号:809 略称:定義なし
     */
    経管栄養("76", "処置内容（経管栄養）", "特医-9", "1", "809"),
    /**
     * コード:77 名称:特別な対応（モニター測定） 表示番号:特医-10 パターンNo:1 特記事項番号:810 略称:定義なし
     */
    モニター測定("77", "特別な対応（モニター測定）", "特医-10", "1", "810"),
    /**
     * コード:78 名称:特別な対応（じょくそうの処置） 表示番号:特医-11 パターンNo:1 特記事項番号:811 略称:定義なし
     */
    じょくそうの処置("78", "特別な対応（じょくそうの処置）", "特医-11", "1", "811"),
    /**
     * コード:79 名称:失禁への対応（カテーテル） 表示番号:特医-12 パターンNo:1 特記事項番号:812 略称:定義なし
     */
    カテーテル("79", "失禁への対応（カテーテル）", "特医-12", "1", "812"),
    /**
     * コード:80 名称:日中の生活 表示番号:10-1 パターンNo:24 特記事項番号:901 略称:定義なし
     */
    日中の生活("80", "日中の生活", "10-1", "24", "901"),
    /**
     * コード:81 名称:外出頻度 表示番号:10-2 パターンNo:13 特記事項番号:902 略称:定義なし
     */
    外出頻度("81", "外出頻度", "10-2", "13", "902"),
    /**
     * コード:82 名称:家族・居住環境、社会生活の状況などの変化 表示番号:10-3 パターンNo:1 特記事項番号:903 略称:定義なし
     */
    状況の変化("82", "家族・居住環境、社会生活の状況などの変化", "10-3", "1", "903");

    private final RString code;
    private final RString fullName;
    private final RString 表示番号;
    private final RString パターンNo;
    private final RString 特記事項番号;
    private final int 連番;

    private NinteichosaKomokuMapping06A(String code, String fullname, String 表示番号, String パターンNo, String 特記事項番号) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.表示番号 = new RString(表示番号);
        this.パターンNo = new RString(パターンNo);
        this.特記事項番号 = new RString(特記事項番号);
        this.連番 = Integer.valueOf(code);
    }

    /**
     * 認定調査票06Aのコードを返します。
     *
     * @return 認定調査票06Aのコード
     */
    @Override
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査票06Aの表示番号を返します。
     *
     * @return 認定調査票06Aの表示番号
     */
    @Override
    public RString get表示番号() {
        return 表示番号;
    }

    /**
     * 認定調査票06AのパターンNoを返します。
     *
     * @return 認定調査票06AのパターンNo
     */
    @Override
    public RString getパターンNo() {
        return パターンNo;
    }

    /**
     * 認定調査票06Aの名称を返します。
     *
     * @return 認定調査票06Aの名称
     */
    @Override
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査票06Aの特記事項番号を返します。
     *
     * @return 認定調査票06Aの特記事項番号
     */
    @Override
    public RString get特記事項番号() {
        return 特記事項番号;
    }

    @Override
    public int get連番() {
        return 連番;
    }

    /**
     * 認定調査票06Aのコードと一致する内容を探します。
     *
     * @param code 認定調査票06Aのコード
     * @return {@code code} に対応する認定調査票06A
     */
    public static NinteichosaKomokuMapping06A toValue(RString code) {
        for (NinteichosaKomokuMapping06A ninteichosaKomokuMapping06A : NinteichosaKomokuMapping06A.values()) {
            if (ninteichosaKomokuMapping06A.code.equals(code)) {
                return ninteichosaKomokuMapping06A;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査票06A"));
    }
}
