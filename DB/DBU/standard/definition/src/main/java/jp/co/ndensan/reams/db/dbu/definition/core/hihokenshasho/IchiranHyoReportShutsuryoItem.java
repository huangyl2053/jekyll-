/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshasho;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.ITableColumnMapping;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票「被保険者台帳一覧表」出力順を表す列挙型です。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 */
public enum IchiranHyoReportShutsuryoItem implements ITableColumnMapping {

    /**
     * hihokenshaNo
     */
    hihokenshaNo("hihokenshaNo", "hihokenshaNo", getテーブル名()),
    /**
     * idoYMD
     */
    idoYMD("idoYMD", "idoYMD", getテーブル名()),
    /**
     * edaNo
     */
    edaNo("edaNo", "edaNo", getテーブル名());
    private final RString column;
    private final RString item;
    private final RString tableName;

    /**
     * コンストラクタです。
     *
     * @param column 項目名
     * @param tableName テーブル名
     */
    IchiranHyoReportShutsuryoItem(String column, String item, String tableName) {
        this.column = new RString(column);
        this.item = new RString(item);
        this.tableName = new RString(tableName);
    }

    private static String getテーブル名() {
        return "";
    }

    @Override
    public RString getColumn() {
        return this.column;
    }

    @Override
    public RString getTableName() {
        return this.tableName;
    }

    @Override
    public RString getItem() {
        return this.item;
    }

    @Override
    public IchiranHyoReportShutsuryoItem toValue(RString column) {
        for (IchiranHyoReportShutsuryoItem relateitem : IchiranHyoReportShutsuryoItem.values()) {
            if (relateitem.column.equals(column)) {
                return relateitem;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
    }

}
