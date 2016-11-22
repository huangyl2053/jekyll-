package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.IBreakPageColumnMapping;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給（不支給）決定通知一覧表ののPageBreakenumクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public enum KetteiTsuchiIchiranBreakPageItem implements IBreakPageColumnMapping {

    /**
     * 郵便番号
     */
    yubinBango("yubinBango", "郵便番号", "yubinBango"),
    /**
     * 町域コード
     */
    choikiCode("choikiCode", "町域コード", "choikiCode"),
    /**
     * 行政区コード
     */
    gyoseikuCode("gyoseikuCode", "行政区コード", "gyoseikuCode"),
    /**
     * 氏名５０音カナ
     */
    kanaMeisho("kanaMeisho", "氏名５０音カナ", "kanaMeisho"),
    /**
     * 市町村コード
     */
    hokenshaNo("hokenshaNo", "市町村コード", "hokenshaNo"),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo("shoKisaiHokenshaNo", "証記載保険者番号", "shoKisaiHokenshaNo"),
    /**
     * 被保険者番号
     */
    hiHokenshaNo("hiHokenshaNo", "被保険者番号", "hiHokenshaNo"),
    /**
     * 整理番号
     */
    seiriNo("seiriNo", "整理番号", "seiriNo"),
    /**
     * 決定通知番号
     */
    ketteiTsuchiNo("ketteiTsuchiNo", "決定通知番号", "ketteiTsuchiNo"),
    /**
     * 申請者区分
     */
    shinseishaKubun("shinseishaKubun", "申請者区分", "shinseishaKubun");

    private final RString column;
    private final RString item;
    private final RString breakPageName;

    /**
     * コンストラクタです。
     *
     * @param column 項目名
     * @param tableName テーブル名
     */
    KetteiTsuchiIchiranBreakPageItem(String column, String item, String breakPageName) {
        this.column = new RString(column);
        this.item = new RString(item);
        this.breakPageName = new RString(breakPageName);
    }

    @Override
    public RString getColumn() {
        return this.column;
    }

    @Override
    public RString getItem() {
        return this.item;
    }

    @Override
    public RString getBreakPageName() {
        return this.breakPageName;
    }

    @Override
    public KetteiTsuchiIchiranBreakPageItem toValue(RString item) {
        for (KetteiTsuchiIchiranBreakPageItem relateitem
                : KetteiTsuchiIchiranBreakPageItem.values()) {
            if (relateitem.item.equals(item)) {
                return relateitem;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
    }
}
