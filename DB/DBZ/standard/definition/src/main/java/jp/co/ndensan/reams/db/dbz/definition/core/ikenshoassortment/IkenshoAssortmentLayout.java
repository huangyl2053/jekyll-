package jp.co.ndensan.reams.db.dbz.definition.core.ikenshoassortment;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8438
 */
public enum IkenshoAssortmentLayout {
    主治医意見書作成依頼書(1, "DBE221071_IkenshoAssortment_Iraisho"),
    介護保険指定医依頼兼主治医意見書提出依頼書(2, "DBE221071_IkenshoAssortment_TeishutsuIraisho"),
    主治医意見書記入用紙_片面_白黒_表(3, "DBE221071_IkenshoAssortment_Kinyuyoshi_Katamen_Mono_Omote"),
    主治医意見書記入用紙_片面_白黒_裏(4, "DBE221071_IkenshoAssortment_Kinyuyoshi_Katamen_Mono_Ura"),
    主治医意見書記入用紙_両面_白黒_表(5, "DBE221071_IkenshoAssortment_Kinyuyoshi_Ryomen_Mono_Omote"),
    主治医意見書記入用紙_両面_白黒_裏(6, "DBE221071_IkenshoAssortment_Kinyuyoshi_Ryomen_Mono_Ura"),
    主治医意見書記入用紙OCR_片面_カラー表(7, "DBE221071_IkenshoAssortment_Kinyuyoshi_Katamen_Color_Omote"),
    主治医意見書記入用紙OCR_片面_カラー裏(8, "DBE221071_IkenshoAssortment_Kinyuyoshi_Katamen_Color_Ura"),
    主治医意見書記入用紙OCR_両面_カラー表(9, "DBE221071_IkenshoAssortment_Kinyuyoshi_Ryomen_Color_Omote"),
    主治医意見書記入用紙OCR_両面_カラー裏(10, "DBE221071_IkenshoAssortment_Kinyuyoshi_Ryomen_Color_Ura"),
    主治医意見書記入用紙OCR12(11, "DBE221071_IkenshoAssortment_Kinyuyoshi_OCR12"),
    主治医意見書記入用紙OCR14(12, "DBE221071_IkenshoAssortment_Kinyuyoshi_OCR14"),
    主治医意見書記入用紙_ORCA表(13, "DBE221071_IkenshoAssortment_Kinyuyoshi_ORCA_Omote"),
    主治医意見書記入用紙_ORCA裏(14, "DBE221071_IkenshoAssortment_Kinyuyoshi_ORCA_Ura"),
    主治医意見書作成料請求書(15, "DBE221071_IkenshoAssortment_SakuseiryoSeikyusho"),
    介護保険診断命令書(16, "DBE221071_IkenshoAssortment_Meireisho"),
    主治医意見書_空白ページ(17, "DBE221071_IkenshoAssortment_BlankPage");
    

    /**
     * FormGroupIndexです。
     */
    public int index;
    
    /**
     * FormGroupIdです。
     */
    public RString key;
    private IkenshoAssortmentLayout(int index, String key) {
        this.index = index;
        this.key = new RString(key);
    }
    
    /**
     * FormGroupIdの一覧を取得します。
     * @return List<RString>
     */
    public static List<RString> getKeys() {
        List<RString> list = new ArrayList<>();
        for (IkenshoAssortmentLayout item : IkenshoAssortmentLayout.values()) {
            list.add(item.key);
        }
        return list;
    }
    
    /**
     * FormGroupIndexを取得します。
     * @return int
     */
    public int getIndex() {
        return this.index;
    }
}
