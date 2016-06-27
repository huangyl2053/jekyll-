package jp.co.ndensan.reams.db.dba.definition.core.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.IBreakPageColumnMapping;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票「被保険者台帳一覧表」を表す列挙型です。
 *
 * @reamsid_L DBA-0510-070 duanzhanli
 */
public enum BreakPageRelateItem implements IBreakPageColumnMapping {

    /**
     * shichosonCode
     */
    shichosonCode("shichosonCode", "市町村コード", "shichosonCode"),
    /**
     * shichosonName
     */
    shichosonName("shichosonName", "市町村名", "shichosonName"),
    /**
     * hihokennshaNo
     */
    hihokennshaNo("hihokennshaNo", "被保険者番号", "listNo_1"),
    /**
     * kanaMeisho
     */
    kanaMeisho("kanaMeisho", "氏名カナ", "listUpper_1"),
    /**
     * seibetsu
     */
    seibetsu("seibetsu", "性別", "listUpper_2"),
    /**
     * nenrei
     */
    nenrei("nenrei", "年齢", "listUpper_3"),
    /**
     * gyoseiku
     */
    gyoseiku("gyoseiku", "行政区", "listUpper_4"),
    /**
     * yubinBango
     */
    yubinBango("yubinBango", "郵便番号", "listUpper_5"),
    /**
     * shikibetsuCode
     */
    shikibetsuCode("shikibetsuCode", "識別コード", "listUpper_6"),
    /**
     * jyotaiKubun
     */
    jyotaiKubun("jyotaiKubun", "状態区分", "listUpper_7"),
    /**
     * seiho
     */
    seiho("seiho", "生保", "listUpper_8"),
    /**
     * listBiko
     */
    listBiko("listBiko", "備考", "listBiko_1"),
    /**
     * meisho
     */
    meisho("meisho", "氏名", "listLower_1"),
    /**
     * birthYMD
     */
    birthYMD("birthYMD", "生年月日", "listLower_2"),
    /**
     * jusho
     */
    jusho("jusho", "住所", "listLower_3"),
    /**
     * setaiCode
     */
    setaiCode("setaiCode", "世帯コード", "listLower_4"),
    /**
     * shikakuKubun
     */
    shikakuKubun("shikakuKubun", "資格区分", "listLower_5"),
    /**
     * rofuku
     */
    rofuku("rofuku", "老福", "listLower_6");

    private final RString column;
    private final RString item;
    private final RString breakPageName;

    /**
     * コンストラクタです。
     *
     * @param column 項目名
     * @param tableName テーブル名
     */
    BreakPageRelateItem(String column, String item, String breakPageName) {
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
    public BreakPageRelateItem toValue(RString item) {
        for (BreakPageRelateItem relateitem : BreakPageRelateItem.values()) {
            if (relateitem.item.equals(item)) {
                return relateitem;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
    }
}
