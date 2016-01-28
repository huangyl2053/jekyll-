package jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護事業者指定サービステーブルの項目定義クラスです。
 * <br/> 介護事業者単位に利用できるサービスを管理する
 */
public enum DbT7063KaigoJigyoshaShiteiService implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * 有効開始日
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * 有効終了日
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * 異動日
     */
    idoYMD(2147483647, 0),
    /**
     * 異動事由
     */
    idoJiyu(2, 0),
    /**
     * 指定番号
     */
    shiteiNo(2, 0),
    /**
     * 基本情報準拠区分
     */
    kihonJohoJunkyoKubun(1, 0),
    /**
     * 事業開始日
     */
    jigyoKaishiYMD(2147483647, 0),
    /**
     * 事業休止日
     */
    jigyoKyushiYMD(2147483647, 0),
    /**
     * 事業再開日
     */
    jigyoSaikaiYMD(2147483647, 0),
    /**
     * 事業廃止日
     */
    jigyoHaishiYMD(2147483647, 0),
    /**
     * 事業者名称
     */
    jigyoshaName(2147483647, 0),
    /**
     * 事業者名称カナ
     */
    jigyoshaNameKana(2147483647, 0),
    /**
     * 事業者郵便番号
     */
    jigyoshaYubinNo(2147483647, 0),
    /**
     * 事業者住所
     */
    jigyoshaAddress(2147483647, 0),
    /**
     * 事業者住所カナ
     */
    jigyoshaAddressKana(100, 0),
    /**
     * 事業者電話番号
     */
    jigyoshaTelNo(2147483647, 0),
    /**
     * 事業者FAX番号
     */
    jigyoshaFaxNo(2147483647, 0),
    /**
     * 登録保険者番号
     */
    torokuHokenshaNo(6, 0),
    /**
     * 受領委任の有無
     */
    juryoininUmu(2147483647, 0),
    /**
     * 登録開始日
     */
    torokuKaishiYMD(2147483647, 0),
    /**
     * 登録終了日
     */
    torokuShuryoYMD(2147483647, 0),
    /**
     * 管理者氏名
     */
    kanrishaName(2147483647, 0),
    /**
     * 管理者氏名カナ
     */
    kanrishaNameKana(2147483647, 0),
    /**
     * 管理者住所郵便番号
     */
    kanrishaYubinNo(2147483647, 0),
    /**
     * 管理者住所
     */
    kanrishaAddress(2147483647, 0),
    /**
     * 管理者住所カナ
     */
    kanrishaAddressKana(50, 0),
    /**
     * 口座情報準拠区分
     */
    kozaJohoJunkyoKubun(1, 0),
    /**
     * 銀行コード
     */
    ginkoCode(2147483647, 0),
    /**
     * 支店コード
     */
    shitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(2147483647, 0),
    /**
     * 口座番号
     */
    kozaNo(2147483647, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(2147483647, 0),
    /**
     * 社会福祉法人軽減事業実施の有無
     */
    shakaiFukushihoujinKeigenjigyouJisshi_umu(2147483647, 0),
    /**
     * 生活保護法による指定の有無
     */
    seikatsuhogohouShitei_umu(2147483647, 0),
    /**
     * 施設等の区分
     */
    shisetsunadoKubun(2147483647, 0),
    /**
     * 人員配置区分
     */
    jininHaichiKubun(2147483647, 0),
    /**
     * 特別地域加算の有無
     */
    tokubetsuChiikiKasan_umu(2147483647, 0),
    /**
     * 緊急時訪問介護加算の有無
     */
    kinkyujiHomonkaigoKasan_umu(2147483647, 0),
    /**
     * 特別管理体制
     */
    tokubetsuKanriTaisei(2147483647, 0),
    /**
     * 機能訓練指導体制の有無
     */
    kinoKunrenShidoTaisei_umu(2147483647, 0),
    /**
     * 食事提供体制の有無
     */
    shokujiTeikyoTaisei_umu(2147483647, 0),
    /**
     * 入浴介助体制の有無
     */
    nyuyokuKaijoTaisei_umu(2147483647, 0),
    /**
     * 特別入浴介助体制の有無
     */
    tokubetsuNyuyokuKaijoTaisei_umu(2147483647, 0),
    /**
     * 常勤専従医師配置の有無
     */
    joukinsenjuIshiHaichi_umu(2147483647, 0),
    /**
     * 医師の配置基準
     */
    ishiHaichiKijun(2147483647, 0),
    /**
     * 精神科医師定期的療養指導の有無
     */
    seisinkaIshiTeikitekiRyouyousidou_umu(2147483647, 0),
    /**
     * 夜間勤務条件基準
     */
    yakanKinmuJokenKijun(2147483647, 0),
    /**
     * 認知症専門棟の有無
     */
    ninchishouSenmontou_umu(2147483647, 0),
    /**
     * 食事提供の状況
     */
    shokujiTeikyoJokyo(2147483647, 0),
    /**
     * 送迎体制
     */
    sougeiTaisei(2147483647, 0),
    /**
     * リハビリテーション提供体制（総合リハビリテーション施設）の有無
     */
    rehaTeikyoTaisei_SogoRehaShisetsu_umu(2147483647, 0),
    /**
     * リハビリテーション提供体制（理学療法Ⅱ）の有無
     */
    rehaTeikyoTaisei_RigakuRyohoII_umu(2147483647, 0),
    /**
     * リハビリテーション提供体制（理学療法Ⅲ）の有無
     */
    rehaTeikyoTaisei_RigakuRyohoIII_umu(2147483647, 0),
    /**
     * リハビリテーション提供体制（作業療法Ⅱ）の有無
     */
    rehaTeikyoTaisei_SagyoRyohoII_umu(2147483647, 0),
    /**
     * リハビリテーション提供体制（精神科作業療法）の有無
     */
    rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(2147483647, 0),
    /**
     * リハビリテーション提供体制（その他）の有無
     */
    rehaTeikyoTaisei_Sonota_umu(2147483647, 0),
    /**
     * リハビリテーションの加算状況の有無
     */
    rehabilitationKasanJokyo(2147483647, 0),
    /**
     * 療養環境基準
     */
    ryoyoKankyoKijun(2147483647, 0),
    /**
     * 医師の欠員による減算の状況の有無
     */
    ishiKetuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 看護職員の欠員による減算の状況の有無
     */
    kangoShokuinKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 理学療法士の欠員による減算の状況の有無
     */
    rigakuRyouhousiKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 作業療法士の欠員による減算の状況の有無
     */
    sagyouRyouhousiKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 介護職員の欠員による減算の状況の有無
     */
    kaigoShokuinKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 介護支援専門員の欠員による減算の状況の有無
     */
    kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 介護従業者の欠員による減算の状況の有無
     */
    kaigoJujishaKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 感染対策指導管理の有無
     */
    kansenTaisakuSidoKanri_umu(2147483647, 0),
    /**
     * 重症皮膚潰瘍指導管理の有無
     */
    jushoHifuKaiyouShidoKanri_umu(2147483647, 0),
    /**
     * 薬剤管理指導の有無
     */
    yakuzaiKaniriShido_umu(2147483647, 0),
    /**
     * 障害者生活支援体制の有無
     */
    shogaishaSeikatsuShienTaisei_umu(2147483647, 0),
    /**
     * 地域区分コード
     */
    chiikiKubunCode(2147483647, 0),
    /**
     * 時間延長サービス体制
     */
    jikanEnchoServiceTaisei(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制
     */
    kobetsuRehabilitationTeikyoTaisei(2147483647, 0),
    /**
     * 居住費対策
     */
    kyojuhiTaisaku(2147483647, 0),
    /**
     * 夜間ケアの有無
     */
    yakanCare_umu(2147483647, 0),
    /**
     * リハビリテーション機能強化の有無
     */
    rehabilitationKinoKyoka_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（総合リハビリテーション施設）の有無
     */
    kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無1
     */
    kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（理学療法Ⅲ）の有無
     */
    kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（作業療法Ⅱ）の有無
     */
    kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅰ）の有無
     */
    kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅱ）の有無
     */
    kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(2147483647, 0),
    /**
     * 言語聴覚士の欠員による減算の状況の有無
     */
    gengoChokakushiKetsuinGenzanJokyo_umu(2147483647, 0),
    /**
     * 栄養管理の評価
     */
    eiyouKanriHyoka(2147483647, 0),
    /**
     * 特定事業所加算（訪問介護）の有無
     */
    tokuteijigyoushoKasan_HomonKaigo_umu(2147483647, 0),
    /**
     * 若年性認知症ケア体制の有無
     */
    jakunenseiNinchishoCareTaisei_umu(2147483647, 0),
    /**
     * 運動器機能向上体制の有無
     */
    undokiKinoKojoTaisei_umu(2147483647, 0),
    /**
     * 栄養マネジメント（改善）体制の有無
     */
    eiyoManagement_KaizenTaisei_umu(2147483647, 0),
    /**
     * 口腔機能向上体制の有無
     */
    kokuKinoKojoTaisei_umu(2147483647, 0),
    /**
     * 事業所評価加算（申出）の有無
     */
    jigyoshoHyokaKasan_Moshide_umu(2147483647, 0),
    /**
     * 事業所評価加算（決定）の有無
     */
    jigyoshoHyokaKasan_Kettei_umu(2147483647, 0),
    /**
     * 緊急受入体制の有無
     */
    kinkyuUkeireTaisei_umu(2147483647, 0),
    /**
     * 夜間看護体制の有無
     */
    yakanKangoTaisei_umu(2147483647, 0),
    /**
     * 特定事業所加算（居宅介護支援）の有無
     */
    tokuteijigyoshoKasan_Kyotakukaigoshien_umu(2147483647, 0),
    /**
     * 介護支援専門員数（専従の常勤者）
     */
    kaigoShienSemmoninSenjuJokinshaNinsu(5, 0),
    /**
     * 介護支援専門員数（専従の非常勤者）
     */
    kaigoSienSemmoninSenjuHijokinshaNinsu(5, 0),
    /**
     * 介護支援専門員数（兼務の常勤者）
     */
    kaigoSienSemmoninKemmuJokinshaNinsu(5, 0),
    /**
     * 介護支援専門員数（兼務の非常勤者）
     */
    kaigoSienSemmoninKemmuHijokinshaNinsu(5, 0),
    /**
     * 訪問介護サービス提供責任者数
     */
    homonkaigoServiceTeikyoSekininshaNinsu(5, 0),
    /**
     * 訪問介護員数（専従の常勤者）
     */
    homonkaigoSenjuJokinshaNinsu(5, 0),
    /**
     * 訪問介護員数（専従の非常勤者）
     */
    homonkaigoSenjuHijokinshaNinsu(5, 0),
    /**
     * 訪問介護員数（兼務の常勤者）
     */
    homonkaigoKemmuJokinshaNinsu(5, 0),
    /**
     * 訪問介護員数（兼務の非常勤者）
     */
    homonkaigoKemmuHijokinshaNinsu(5, 0),
    /**
     * 訪問介護員数（常勤換算後の人数）
     */
    homonkaigoJokinKanzangoNinsu(5, 0),
    /**
     * 利用定員数
     */
    riyoTeiinNinsu(5, 0),
    /**
     * 指定有効開始日
     */
    shiteiYukoKaishiYMD(2147483647, 0),
    /**
     * 指定有効終了日
     */
    shiteiYukoShuryoYMD(2147483647, 0),
    /**
     * 指定更新申請中区分
     */
    shiteiKoshinShinseichuKubun(2147483647, 0),
    /**
     * 効力停止開始日
     */
    koryokuTeishiKaishiYMD(2147483647, 0),
    /**
     * 効力停止終了日
     */
    koryokuTeishiShuryoYMD(2147483647, 0),
    /**
     * 大規模事業所該当の有無
     */
    daikiboJigyoshaGaito_umu(2147483647, 0),
    /**
     * 準ユニットケア体制の有無
     */
    junUnitCareTaisei_umu(2147483647, 0),
    /**
     * 重度化対応体制の有無
     */
    judokaTaioTaisei_umu(2147483647, 0),
    /**
     * 医療連携体制の有無
     */
    iryoRenkeiTaisei_umu(2147483647, 0),
    /**
     * ユニットケア体制の有無
     */
    unitCareTaisei_umu(2147483647, 0),
    /**
     * 在宅・入所相互利用体制の有無
     */
    zaitaku_nyushoSogoRiyoTaisei_umu(2147483647, 0),
    /**
     * ターミナルケア体制（看取り介護体制）の有無
     */
    terminalCareTaisei_umu(2147483647, 0),
    /**
     * 身体拘束廃止取組の有無
     */
    shintaiKosokuHaishiTorikumi_umu(2147483647, 0),
    /**
     * 小規模拠点集合体制の有無
     */
    shokiboKyotenShugoTaisei_umu(2147483647, 0),
    /**
     * 認知症ケア加算の有無
     */
    ninchishoCareKasan_umu(2147483647, 0),
    /**
     * 個別機能訓練体制の有無
     */
    kobetsuKinoKunrenTaisei_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（理学療法Ⅰ）の有無
     */
    kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無2
     */
    kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（作業療法）の有無
     */
    kobetsuRehaTeikyoTaisei_SagyoRyoho_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（言語聴覚療法）の有無
     */
    kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（その他）の有無
     */
    kobetsuRehaTeikyoTaisei_Sonota_umu(2147483647, 0),
    /**
     * 設備基準
     */
    setsubiKijun(2147483647, 0),
    /**
     * 療養体制維持特別加算
     */
    ryoyoTaiseiIjiTokubetsuKasan(2147483647, 0),
    /**
     * 個別リハビリテーション提供体制（リハビリテーション指導管理）の有無
     */
    kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(2147483647, 0),
    /**
     * ３級ヘルパー体制
     */
    sankyuHelperTaisei(2147483647, 0),
    /**
     * 中山間地域等における小規模事業所加算（地域に関する状況）
     */
    chuSankanChiikiShokiboJigyoshoKasan_chiiki(2147483647, 0),
    /**
     * 中山間地域等における小規模事業所加算（規模に関する状況）
     */
    chuSankanChiikiShokiboJigyoushoKasan_kibo(2147483647, 0),
    /**
     * サービス提供体制強化加算
     */
    serviceTeikyoTaiseiKyokaKasan(2147483647, 0),
    /**
     * 認知症短期集中リハビリテーション加算
     */
    ninchishoTankiShuchuRehabilitationKasan(2147483647, 0),
    /**
     * 若年性認知症利用者（入所者・患者）受入加算
     */
    jakunenseiNinchishoRiyoushaUkeeireKasan(2147483647, 0),
    /**
     * 看護体制加算
     */
    kangoTaiseiKasan(2147483647, 0),
    /**
     * 夜勤職員配置加算
     */
    yakinShokuinHaichiKasan(2147483647, 0),
    /**
     * 療養食加算
     */
    ryoyoShokuKasan(2147483647, 0),
    /**
     * 日常生活継続支援加算
     */
    nichijoSeikatsuKeizokuShienKasan(2147483647, 0),
    /**
     * 認知症専門ケア加算
     */
    ninchishoSemmonCareKasan(2147483647, 0),
    /**
     * ２４時間通報対応加算
     */
    twentyFourHoursTsuhoTaioKasan(2147483647, 0),
    /**
     * 看護職員配置加算
     */
    kangoShokuinHaichiKasan(2147483647, 0),
    /**
     * 夜間ケア加算
     */
    yakanCareKasan(2147483647, 0),
    /**
     * 集団コミュニケーション療法の有無
     */
    shudanCommunicationRyoho_umu(2147483647, 0),
    /**
     * サービス提供体制強化加算（空床型）
     */
    serviceTeikyoTaiseiKyokaKasan_Karadokogata(2147483647, 0),
    /**
     * 日中の身体介護２０分未満体制の有無
     */
    nitchuShintaikaigoTaise_20funmiman_umu(2147483647, 0),
    /**
     * サービス提供責任者体制の有無
     */
    serviceTeikyoSekininshaTaisei_umu(2147483647, 0),
    /**
     * 同一建物に居住する利用者の減算の有無
     */
    doitsuTatemonoKyojuRiyoshaGenzan_umu(2147483647, 0),
    /**
     * 緊急短期入所体制確保加算
     */
    kinkyuTankiNyushoTaiseiKakuhoKasan(2147483647, 0),
    /**
     * 在宅復帰・在宅療養支援機能加算
     */
    zaitakuFukki_ZaitakuRyoyoShienKinoKasan(2147483647, 0),
    /**
     * 生活機能向上グループ活動加算
     */
    seikatuKinoKojoGroupKatsudoKasan(2147483647, 0),
    /**
     * 介護職員処遇改善加算
     */
    kaigoShokuinShoguKaizenKasan(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7063KaigoJigyoshaShiteiService(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
