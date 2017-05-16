package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBE2040001のDataGridの列名です。
 * @author n8438
 */
public enum ShujiiIkenshoIraiColunmData {
    
    /**
     * 状態
     */
    状態("jyotai", ShujiiIkenshoIraiCellType.String),
    /**
     * 保険者
     */
    保険者("hokensha", ShujiiIkenshoIraiCellType.String),
    /**
     * 認定申請日
     */
    認定申請日("ninteiShinseiDay", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 被保番号
     */
    被保番号("hihoNumber", ShujiiIkenshoIraiCellType.String),
    /**
     * 氏名
     */
    氏名("hihoShimei", ShujiiIkenshoIraiCellType.String),
    /**
     * 申請時
     */
    申請時("shinseiKubunShinseiji", ShujiiIkenshoIraiCellType.String),
    /**
     * 再意見書_回数
     */
    再意見書_回数("ikenshoIraiIkenCount", ShujiiIkenshoIraiCellType.TextBoxNum),
    /**
     * 依頼日
     */
    依頼日("ikenshoIraiDay", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 依頼書_発行日
     */
    依頼書_発行日("ikenshoIraiIraishoHakkoDay", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 意見書_出力日
     */
    意見書_出力日("ikenshoIraiIkenshoShutsuryokuDay", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 提出期限
     */
    提出期限("ikenshoIraiKigen", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 作成料_請求区分
     */
    作成料_請求区分("sakuseiryoSeikyuKubun", ShujiiIkenshoIraiCellType.String),
    /**
     * 医療機関
     */
    医療機関("konkaiShujiiIryokikan", ShujiiIkenshoIraiCellType.String),
    /**
     * 主治医
     */
    主治医("konkaiShujii", ShujiiIkenshoIraiCellType.String),
    /**
     * 前回医療機関
     */
    前回医療機関("zenkaiIryokikan", ShujiiIkenshoIraiCellType.String),
    /**
     * 前回主治医
     */
    前回主治医("zenkaiShujii", ShujiiIkenshoIraiCellType.String),
    /**
     * 郵便番号
     */
    郵便番号("yubinNumber", ShujiiIkenshoIraiCellType.String),
    /**
     * 住所
     */
    住所("jusho", ShujiiIkenshoIraiCellType.String),
    /**
     * 入所施設
     */
    入所施設("nyushoShisetsu", ShujiiIkenshoIraiCellType.String),
    /**
     * 督促_発行日
     */
    督促_発行日("ikenshoTokusokuHakkoDay", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 方法
     */
    方法("ikenshoTokusokuHoho", ShujiiIkenshoIraiCellType.String),
    /**
     * 回数
     */
    回数("ikenshoTokusokuCount", ShujiiIkenshoIraiCellType.TextBoxNum),
    /**
     * 期限
     */
    期限("ikenshoTokusokuLimit", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 経過日数
     */
    経過日数("keikaNissu", ShujiiIkenshoIraiCellType.TextBoxNum),
    /**
     * 完了日
     */
    完了日("ikenshoIraiKanryoDay", ShujiiIkenshoIraiCellType.TextBoxDate),
    /**
     * 申請書管理番号
     */
    申請書管理番号("shinseishoKanriNo", ShujiiIkenshoIraiCellType.String),
    /**
     * 入所施設コード
     */
    入所施設コード("nyushoShisetsuCode", ShujiiIkenshoIraiCellType.String),
    /**
     * 市町村
     */
    市町村("shichoson", ShujiiIkenshoIraiCellType.String);
    
    private final RString name;
    private final ShujiiIkenshoIraiCellType cellType;
    
    private ShujiiIkenshoIraiColunmData(String name, ShujiiIkenshoIraiCellType cellType) {
        this.name = new RString(name);
        this.cellType = cellType;
    }
    
    /**
     * 列名を返します。
     * @return name
     */
    public RString getName() {
        return this.name;
    }
    
    /**
     * cellTypeを返します。
     * @return cellType
     */
    public ShujiiIkenshoIraiCellType getCellType() {
        return this.cellType;
    }
    
    /**
     * 列名からキーを返します。
     * @param name 列名
     * @return ShujiiIkenshoIraiSortData
     */
    public static ShujiiIkenshoIraiColunmData getSortKey(RString name) {
        for (ShujiiIkenshoIraiColunmData key : ShujiiIkenshoIraiColunmData.values()) {
            if (name.equals(key.getName())) {
                return key;
            }
        }
        return null;
    }
}
