package jp.co.ndensan.reams.db.dba.definition.core.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.ITableColumnMapping;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳管理を表す列挙型です。
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 */
public enum HihokenshaDaichoRelateItem implements ITableColumnMapping {

    /**
     * hihokenshaNo
     */
    hihokenshaNo("hihokenshaNo", "dbT1001HihokenshaDaicho_hihokenshaNo", getテーブル名()),
    /**
     * idoYMD
     */
    idoYMD("idoYMD", "dbT1001HihokenshaDaicho_idoYMD", getテーブル名()),
    /**
     * edaNo
     */
    edaNo("edaNo", "dbT1001HihokenshaDaicho_edaNo", getテーブル名()),
    /**
     * idoJiyuCode
     */
    idoJiyuCode("idoJiyuCode", "dbT1001HihokenshaDaicho_idoJiyuCode", getテーブル名()),
    /**
     * shichosonCode
     */
    shichosonCode("shichosonCode", "dbT1001HihokenshaDaicho_shichosonCode", getテーブル名()),
    /**
     * shikibetsuCode
     */
    shikibetsuCode("shikibetsuCode", "dbT1001HihokenshaDaicho_shikibetsuCode", getテーブル名()),
    /**
     * shikakuShutokuJiyuCode
     */
    shikakuShutokuJiyuCode("shikakuShutokuJiyuCode", "dbT1001HihokenshaDaicho_shikakuShutokuJiyuCode", getテーブル名()),
    /**
     * shikakuShutokuYMD
     */
    shikakuShutokuYMD("shikakuShutokuYMD", "dbT1001HihokenshaDaicho_shikakuShutokuYMD", getテーブル名()),
    /**
     * shikakuShutokuTodokedeYMD
     */
    shikakuShutokuTodokedeYMD("shikakuShutokuTodokedeYMD", "dbT1001HihokenshaDaicho_shikakuShutokuTodokedeYMD", getテーブル名()),
    /**
     * ichigoShikakuShutokuYMD
     */
    ichigoShikakuShutokuYMD("ichigoShikakuShutokuYMD", "dbT1001HihokenshaDaicho_ichigoShikakuShutokuYMD", getテーブル名()),
    /**
     * hihokennshaKubunCode
     */
    hihokennshaKubunCode("hihokennshaKubunCode", "dbT1001HihokenshaDaicho_hihokennshaKubunCode", getテーブル名()),
    /**
     * shikakuSoshitsuJiyuCode
     */
    shikakuSoshitsuJiyuCode("shikakuSoshitsuJiyuCode", "dbT1001HihokenshaDaicho_shikakuSoshitsuJiyuCode", getテーブル名()),
    /**
     * shikakuSoshitsuYMD
     */
    shikakuSoshitsuYMD("shikakuSoshitsuYMD", "dbT1001HihokenshaDaicho_shikakuSoshitsuYMD", getテーブル名()),
    /**
     * shikakuSoshitsuTodokedeYMD
     */
    shikakuSoshitsuTodokedeYMD("shikakuSoshitsuTodokedeYMD", "dbT1001HihokenshaDaicho_shikakuSoshitsuTodokedeYMD", getテーブル名()),
    /**
     * shikakuHenkoJiyuCode
     */
    shikakuHenkoJiyuCode("shikakuHenkoJiyuCode", "dbT1001HihokenshaDaicho_shikakuHenkoJiyuCode", getテーブル名()),
    /**
     * shikakuHenkoYMD
     */
    shikakuHenkoYMD("shikakuHenkoYMD", "dbT1001HihokenshaDaicho_shikakuHenkoYMD", getテーブル名()),
    /**
     * shikakuHenkoTodokedeYMD
     */
    shikakuHenkoTodokedeYMD("shikakuHenkoTodokedeYMD", "dbT1001HihokenshaDaicho_shikakuHenkoTodokedeYMD", getテーブル名()),
    /**
     * jushochitokureiTekiyoJiyuCode
     */
    jushochitokureiTekiyoJiyuCode("jushochitokureiTekiyoJiyuCode", "dbT1001HihokenshaDaicho_jushochitokureiTekiyoJiyuCode", getテーブル名()),
    /**
     * jushochitokureiTekiyoYMD
     */
    jushochitokureiTekiyoYMD("jushochitokureiTekiyoYMD", "dbT1001HihokenshaDaicho_jushochitokureiTekiyoYMD", getテーブル名()),
    /**
     * jushochitokureiTekiyoTodokedeYMD
     */
    jushochitokureiTekiyoTodokedeYMD("jushochitokureiTekiyoTodokedeYMD", "dbT1001HihokenshaDaicho_jushochitokureiTekiyoTodokedeYMD", getテーブル名()),
    /**
     * jushochitokureiKaijoJiyuCode
     */
    jushochitokureiKaijoJiyuCode("jushochitokureiKaijoJiyuCode", "dbT1001HihokenshaDaicho_jushochitokureiKaijoJiyuCode", getテーブル名()),
    /**
     * jushochitokureiKaijoYMD
     */
    jushochitokureiKaijoYMD("jushochitokureiKaijoYMD", "dbT1001HihokenshaDaicho_jushochitokureiKaijoYMD", getテーブル名()),
    /**
     * jushochitokureiKaijoTodokedeYMD
     */
    jushochitokureiKaijoTodokedeYMD("jushochitokureiKaijoTodokedeYMD", "dbT1001HihokenshaDaicho_jushochitokureiKaijoTodokedeYMD", getテーブル名()),
    /**
     * jushochiTokureiFlag
     */
    jushochiTokureiFlag("jushochiTokureiFlag", "dbT1001HihokenshaDaicho_jushochiTokureiFlag", getテーブル名()),
    /**
     * koikinaiJushochiTokureiFlag
     */
    koikinaiJushochiTokureiFlag("koikinaiJushochiTokureiFlag", "dbT1001HihokenshaDaicho_koikinaiJushochiTokureiFlag", getテーブル名()),
    /**
     * koikinaiTokureiSochimotoShichosonCode
     */
    koikinaiTokureiSochimotoShichosonCode("koikinaiTokureiSochimotoShichosonCode",
            "dbT1001HihokenshaDaicho_koikinaiTokureiSochimotoShichosonCode", getテーブル名()),
    /**
     * kyuShichosonCode
     */
    kyuShichosonCode("kyuShichosonCode", "dbT1001HihokenshaDaicho_kyuShichosonCode", getテーブル名()),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag("logicalDeletedFlag", "dbT1001HihokenshaDaicho_logicalDeletedFlag", getテーブル名());

    private final RString column;
    private final RString item;
    private final RString tableName;

    /**
     * コンストラクタです。
     *
     * @param column 項目名
     * @param tableName テーブル名
     */
    HihokenshaDaichoRelateItem(String column, String item, String tableName) {
        this.column = new RString(column);
        this.item = new RString(item);
        this.tableName = new RString(tableName);
    }

    private static String getテーブル名() {
        return "DbT1001";
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
    public HihokenshaDaichoRelateItem toValue(RString column) {
        for (HihokenshaDaichoRelateItem relateitem : HihokenshaDaichoRelateItem.values()) {
            if (relateitem.column.equals(column)) {
                return relateitem;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
    }
}
