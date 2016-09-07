package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受給者異動送付テーブルの項目定義クラスです。
 */
public enum DbT3001JukyushaIdoRenrakuhyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * 異動年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 異動区分コード
     * <br/>1:新規,2:変更,3:終了
     */
    idoKubunCode(1, 0),
    /**
     * 受給者異動事由
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     */
    jukyushaIdoJiyu(2, 0),
    /**
     * 証記載保険者番号
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者氏名カナ
     */
    hiHokenshaNameKana(25, 0),
    /**
     * 生年月日
     */
    umareYMD(2147483647, 0),
    /**
     * 性別コード
     */
    seibetsuCode(1, 0),
    /**
     * 資格取得年月日
     */
    shikakuShutokuYMD(2147483647, 0),
    /**
     * 資格喪失年月日
     * <br/>資格喪失者のみ設定
     */
    shikakuSoshitsuYMD(2147483647, 0),
    /**
     * 老人保健市町村番号
     * <br/>老人保健受給者のみ設定
     */
    rojinHokenShichosonNo(8, 0),
    /**
     * 老人保健受給者番号
     * <br/>老人保健受給者のみ設定
     */
    rojinHokenJukyushaNo(7, 0),
    /**
     * 公費負担者番号
     * <br/>福祉事務所からの異動情報提出時のみ設定
     */
    kohiFutanshaNo(8, 0),
    /**
     * 広域連合（政令市）保険者番号
     * <br/>広域連合または政令市の場合のみ広域連合または政令市の保険者番号を設定
     */
    koikiRengoHokenshaNo(2147483647, 0),
    /**
     * 申請種別コード
     * <br/>1:新規申請,2:更新申請,3:変更申請,4:職権
     */
    shinseiShubetsuCode(1, 0),
    /**
     * 変更申請中区分コード
     * <br/>1:申請無し,2:申請中,3:決定済み
     */
    henkoShinseichuKubunCode(1, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * みなし要介護状態区分コード
     * <br/>1:通常の認定,2:みなし認定,3:やむを得ない事由
     */
    minashiYokaigoJotaiKubunCode(1, 0),
    /**
     * 要介護状態区分コード
     * <br/>01:非該当,11:要支援（経過的要介護）,12:要支援１,13:要支援２,21:要介護１,22:要介護２,23:要介護３,24:要介護４,25:要介護５
     */
    yokaigoJotaiKubunCode(2, 0),
    /**
     * 認定有効期間開始年月日
     */
    ninteiYukoKikankaishiYMD(2147483647, 0),
    /**
     * 認定有効期間終了年月日
     */
    ninteiYukoKikanShuryoYMD(8, 0),
    /**
     * 居宅サービス計画作成区分コード
     * <br/>1:居宅介護支援事業所作成,2:自己作成,3:介護予防支援事業所作成
     */
    kyotakuServiceSakuseiKubunCode(1, 0),
    /**
     * 居宅介護支援事業所番号
     * <br/>居宅サービス計画作成区分コードが「2:自己作成」である場合、設定不要
     */
    kyotakuKaigoShienJigyoshoNo(10, 0),
    /**
     * 居宅サービス計画適用開始年月日
     */
    kyotakuServiceTekiyoKaishiYMD(8, 0),
    /**
     * 居宅サービス計画適用終了年月日
     */
    kyotakuServiceTekiyoShuryoYMD(8, 0),
    /**
     * 訪問通所サービス支給限度基準額
     */
    homonTsushoServiceShikyuGendoKijungaku(10, 0),
    /**
     * 訪問通所サービス上限管理適用期間開始年月日
     */
    homonTsushoServiceJogenKanriTekiyoKaishiYMD(2147483647, 0),
    /**
     * 訪問通所サービス上限管理適用期間終了年月日
     */
    homonTsushoServiceJogenKanriTekiyoShuryoYMD(8, 0),
    /**
     * 短期入所サービス支給限度基準額
     */
    tankiNyushoServiceShikyuGendoKijungaku(5, 0),
    /**
     * 短期入所サービス上限管理適用期間開始年月日
     */
    tankinyushoServiceJogenKanriTekiyoKaishiYMD(2147483647, 0),
    /**
     * 短期入所サービス上限管理適用期間終了年月日
     */
    tankinyushoServiceJogenKanriTekiyoShuryoYMD(2147483647, 0),
    /**
     * 公費負担上限額減額有フラグ
     */
    kohiFutanJogenGengakuAriFlag(1, 0),
    /**
     * 償還払化開始年月日
     */
    shokanbaraikaKaishiYMD(8, 0),
    /**
     * 償還払化終了年月日
     */
    shokanbaraikaShuryoYMD(8, 0),
    /**
     * 給付率引下げ開始年月日
     */
    kyufuritsuHikisageKaishiYMD(8, 0),
    /**
     * 給付率引下げ終了年月日
     */
    kyufuritsuHikisageShuryoYMD(8, 0),
    /**
     * 減免申請中区分コード
     * <br/>1:申請無し 
     * <br/>2:申請中 
     * <br/>3:決定済み
     */
    gemmenShinseichuKubunCode(1, 0),
    /**
     * 利用者負担区分コード
     * <br/>1:利用者負担,2:旧措置入所者利用者負担
     */
    riyoshaFutanKubunCode(1, 0),
    /**
     * 給付率
     */
    kyufuritsu(3, 0),
    /**
     * 適用開始年月日
     */
    tekiyoKaishiYMD(8, 0),
    /**
     * 適用終了年月日
     */
    tekiyoShuryoYMD(8, 0),
    /**
     * 標準負担区分コード
     * <br/>1:標準負担,2:特定標準負担
     */
    hyojunFutanKubunCode(1, 0),
    /**
     * 負担額
     */
    futangaku(5, 0),
    /**
     * 負担額適用開始年月日
     */
    futangakuTekiyoKaishiYMD(8, 0),
    /**
     * 負担額適用終了年月日
     */
    futangakuTekiyoShuryoYMD(8, 0),
    /**
     * 特定入所者認定申請中区分コード
     * <br/>1:申請無し,2:申請中,3:決定済み
     */
    tokuteiNyushoshaNinteiShinseichuKubunCode(1, 0),
    /**
     * 特定入所者介護サービス区分コード
     * <br/>1:通常の受給者,2:旧措置入所者
     */
    tokuteiNyushoshaKaigoServiceKubunCode(1, 0),
    /**
     * 課税層の特例減額措置対象フラグ
     * <br/>1:該当無し,2:該当有り
     */
    kaizeisoTokureiGengakuSochiTaishoFlag(1, 0),
    /**
     * 食費負担限度額
     */
    shokuhiFutanGendogaku(4, 0),
    /**
     * 居住費ユニット型個室負担限度額
     */
    kyojuhiUnitGataKoshitsuFutanGendogaku(4, 0),
    /**
     * 居住費ユニット型準個室負担限度額
     */
    kyojuhiUnitGataJunKoshitsuFutanGendogaku(4, 0),
    /**
     * 居住費従来型個室特養等負担限度額
     */
    kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(4, 0),
    /**
     * 居住費従来型個室老健療養等負担限度額
     */
    kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(4, 0),
    /**
     * 居住費多床室負担限度額
     */
    kyujuhiTashoshitsuFutanGendogaku(4, 0),
    /**
     * 負担限度額適用開始年月日
     */
    futanGendogakuTekiyoKaishiYMD(8, 0),
    /**
     * 負担限度額適用終了年月日
     */
    futanGendogakuTekiyoShuryoYMD(8, 0),
    /**
     * 軽減率
     */
    keigenritsu(4, 0),
    /**
     * 軽減率適用開始年月日
     */
    keigenritsuTekiyoKaishiYMD(8, 0),
    /**
     * 軽減率適用終了年月日
     */
    keigenritsuTekiyoShuryoYMD(8, 0),
    /**
     * 小多機能居宅介護利用開始月利用有フラグ
     * <br/>1:利用無し,2:利用有り
     */
    shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(1, 0),
    /**
     * 後期高齢者医療保険者番号
     */
    kokiKoureiIryoHokenshaNo(8, 0),
    /**
     * 後期高齢者医療被保険者番号
     */
    kokikoureiIryoHiHokenshaNo(8, 0),
    /**
     * 国民健康保険保険者番号
     */
    kokuhoHokenshaNo(8, 0),
    /**
     * 国民健康保険被保険者証番号
     */
    kokuhoHiHokenshaNo(20, 0),
    /**
     * 国民健康保険個人番号
     */
    kokuhoKojinNo(10, 0),
    /**
     * 二次予防事業区分コード
     * <br/>1:非該当,2:該当
     */
    nijiyoboJigyoKubunCode(1, 0),
    /**
     * 二次予防事業有効期間開始年月日
     */
    nijiyoboJigyoYukoKikanKaishiYMD(2147483647, 0),
    /**
     * 二次予防事業有効期間終了年月日
     */
    nijiyoboJigyoYukoKikanShuryoYMD(2147483647, 0),
    /**
     * 訂正連絡票フラグ
     * <br/>異動or訂正 訂正ならtrue
     */
    teiseiRenrakuhyoFlag(1, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * 住所地特例対象者区分コード
     */
    jushochiTokureiTaishoshaKubunCode(1, 0),
    /**
     * 施設所在保険者番号
     */
    shisetsuShozaiHokenjaNo(6, 0),
    /**
     * 住所地特例適用開始日
     */
    jushochiTokureiTekiyoKaishiYMD(8, 0),
    /**
     * 住所地特例適用終了日
     */
    jushochiTokureiTekiyoShuryoYMD(8, 0),
    /**
     * 居宅費（新１）負担限度額
     */
    kyotakuhiShin1FutanGendogaku(4, 0),
    /**
     * 居宅費（新２）負担限度額
     */
    kyotakuhiShin2FutanGendogaku(4, 0),
    /**
     * 居宅費（新３）負担限度額
     */
    kyotakuhiShin3FutanGendogaku(4, 0),
    /**
     * 利用者負担割合有効開始日
     */
    riyosyaFutanWariaiYukoKaishiYMD(8, 0),
    /**
     * 利用者負担割合有効終了日
     */
    riyosyaFutanWariaiYukoShuryoYMD(8, 0),
    /**
     * 訂正区分コード
     * <br/>2：修正、3：削除
     */
    teiseiKubunCode(1, 0),
    /**
     * 訂正年月日
     */
    teiseiYMD(2147483647, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3001JukyushaIdoRenrakuhyo(int maxLength, int scale) {
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
