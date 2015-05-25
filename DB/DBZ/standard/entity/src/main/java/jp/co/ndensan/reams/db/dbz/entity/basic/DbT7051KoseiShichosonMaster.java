package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 構成市町村マスタテーブルの項目定義クラスです。
 * <br/> 運用保険者単位に構成市長を管理する
 */
public enum DbT7051KoseiShichosonMaster implements IColumnDefinition {
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
     * 市町村識別ID
     */
    shichosonShokibetsuID(2, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 国保連広域内市町村番号
     */
    kokuhorenKoikiShichosonNo(3, 0),
    /**
     * 市町村名称
     */
    shichosonMeisho(10, 0),
    /**
     * 都道府県名称
     */
    todofukenMeisho(4, 0),
    /**
     * 郡名称
     */
    gunMeisho(8, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    jusho(2147483647, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * 最優先地区コード
     */
    yusenChikuCode(1, 0),
    /**
     * 帳票用都道府県名称表示有無
     */
    tyohyoTodoufukenHyojiUmu(1, 0),
    /**
     * 帳票用郡名称表示有無
     */
    tyohyoGunHyojiUmu(1, 0),
    /**
     * 帳票用市町村名称表示有無
     */
    tyohyoShichosonHyojiUmu(1, 0),
    /**
     * 帳票用住所編集方法
     */
    tyohyoJushoHenshuHouhou(1, 0),
    /**
     * 帳票用方書表示有無
     */
    tyohyoKatagakiHyojiUmu(1, 0),
    /**
     * 外国人氏名表示方法
     */
    gaikokujinHyojiHouhou(1, 0),
    /**
     * 老人保健市町村番号
     */
    rojinhokenShichosonNo(8, 0),
    /**
     * 老人保健受給者番号体系
     */
    rokenJukyushaNoTaikei(1, 0),
    /**
     * 特徴分配集約
     * <br/>0：なし　1：あり（国保／後期）　2：あり（後期）
     */
    tokuchoBunpaishuyaku(1, 0),
    /**
     * 移行日
     */
    ikoYMD(2147483647, 0),
    /**
     * 加入日
     */
    kanyuYMD(2147483647, 0),
    /**
     * 離脱日
     */
    ridatsuYMD(2147483647, 0),
    /**
     * 合併旧市町村区分  １：合併前の旧市町村である ０：最新の広域構成市町村である
     */
    gappeiKyuShichosonKubun(1, 0),
    /**
     * 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる
１：表示する ０：表示しない
     */
    gappeiKyuShichosonHyojiUmu(1, 0),
    /**
     * 合併情報地域番号
     */
    gappeiChiikiNo(2, 0),
    /**
     * 運用保険者番号
     */
    unyoHokenshaNo(2147483647, 0),
    /**
     * 運用開始日
     */
    unyoKaishiYMD(2147483647, 0),
    /**
     * 運用終了日
     */
    unyoShuryoYMD(2147483647, 0),
    /**
     * 運用形態区分
     * <br/>単独

     * <br/>広域連合

     * <br/>一部事務組合
     */
    unyoKeitaiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7051KoseiShichosonMaster(int maxLength, int scale) {
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
