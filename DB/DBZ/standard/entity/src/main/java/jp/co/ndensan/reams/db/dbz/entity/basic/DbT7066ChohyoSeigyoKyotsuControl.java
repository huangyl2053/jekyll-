package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 帳票制御共通コントロールテーブルの項目定義クラスです。
 * <br/> 帳票制御共通項目について、使用状況を管理します。
     * <br/>共通の帳票制御メンテナンス画面への表示にも使用します。
 */
public enum DbT7066ChohyoSeigyoKyotsuControl implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * 帳票分類ID
     */
    chohyoBunruiID(2147483647, 0),
    /**
     * 共通画面使用有無
     */
    kyotsuGamenShiyoUmu(1, 0),
    /**
     * 文書番号使用区分
     * <br/>UR文書番号管理の使用状況を管理　
     * <br/>0：使用しない　
     * <br/>1：画面表示不可（使用はする）　
     * <br/>2：画面表示可
     */
    bunshoNoShiyoKubun(1, 0),
    /**
     * 通知書定型文使用区分
     * <br/>UR通知書定型文の使用状況を管理
     */
    tsuchishoTeikeibunShiyoKubun(1, 0),
    /**
     * 認証者使用区分
     * <br/>UR認証者の使用状況を管理
     */
    ninshoshaShiyoKubun(1, 0),
    /**
     * 帳票出力順使用区分
     * <br/>UR帳票出力順の使用状況を管理
     */
    chohyoShuturyokujunShiyoKubun(1, 0),
    /**
     * 帳票出力順表示方法
     * <br/>UR帳票出力順を使用する場合のモード
     * <br/>1：ALL（すべてを表示）
     * <br/>2：SORT_ONLY（出力順のみ表示）
     * <br/>3：SHUKEI_NONE（出力順、改頁を表示）
     * <br/>4：KAIPEJIJOKEN_NONE（出力順、集計を表示）
     */
    chohyoShuturyokujunHyojiHohho(1, 0),
    /**
     * 介護問合せ先使用区分
     * <br/>介護問合せ先の使用状況を管理
     */
    kaigoToiawasesakiShiyoKubun(1, 0),
    /**
     * 住所編集使用区分
     * <br/>住所編集都道府県名表示有無　
     * <br/>住所編集郡名表示有無　
     * <br/>住所編集市町村名表示有無　
     * <br/>住所編集町域編集方法　
     * <br/>住所編集方書表示有無
     */
    jushoHenshuShiyoKubun(1, 0),
    /**
     * 世帯主表示使用区分
     */
    setainushiHyojiShiyoKubun(1, 0),
    /**
     * カスタマバーコード使用区分
     * <br/>カスタマバーコード使用有無、
     * <br/>カスタマバーコード変換エラー編集方法
     */
    customerBarCodeShiyoKubun(1, 0),
    /**
     * 外部帳票文字切れ制御使用区分
     */
    gaibuChohyoMojigireSeigyoShiyoKubun(1, 0),
    /**
     * 内部帳票文字切れ制御使用区分
     */
    naibuChohyoMojigireSeigyoShiyoKubun(1, 0),
    /**
     * 文字切れ分離制御使用区分
     */
    mojigireBunriSeigyoShiyoKubun(1, 0),
    /**
     * 定型文文字サイズ使用区分
     */
    teikeibunMojiSizeShiyoKubun(1, 0),
    /**
     * 口座マスク使用区分
     */
    kozaMaskShiyoKubun(1, 0),
    /**
     * 口座名義人カナ優先使用区分
     */
    kozaMeigininKanaYusenShiyoKubun(1, 0),
    /**
     * 代行プリント使用区分
     */
    daikoPrintShiyoKubun(1, 0),
    /**
     * 地区表示使用区分
     * <br/>地区表示１　
     * <br/>地区表示２　
     * <br/>地区表示３
     */
    chikuhyojiShiyoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7066ChohyoSeigyoKyotsuControl(int maxLength, int scale) {
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
