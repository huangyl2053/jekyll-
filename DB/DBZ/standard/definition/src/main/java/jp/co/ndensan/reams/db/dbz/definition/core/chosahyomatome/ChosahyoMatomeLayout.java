package jp.co.ndensan.reams.db.dbz.definition.core.chosahyomatome;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ID=DBE221061_ChosahyoIraishoAssortment用のレイアウトです。
 * @author n8438
 */
public enum ChosahyoMatomeLayout {
    認定調査依頼書(1, "DBE221061_ChosahyoIraishoAssortment_Iraisho"),
    認定調査票_概況調査_デザイン(2, "DBE221061_ChosahyoIraishoAssortment_ChosahyoDesign_Gaikyo"),
    認定調査票_基本調査_デザイン_片面(3, "DBE221061_ChosahyoIraishoAssortment_ChosahyoOcrKatamen_Kihon"),
    認定調査票_概況調査_OCR(4, "DBE221061_ChosahyoIraishoAssortment_ChosahyoOcr_Gaikyo"),
    認定調査票_基本調査_OCR_片面(5, "DBE221061_ChosahyoIraishoAssortment_ChosahyoOcr_Kihon_Katamen"),
    認定調査票_基本調査_OCR_両面(6, "DBE221061_ChosahyoIraishoAssortment_ChosahyoOcr_Kihon_Ryomen"),
    認定調査票_特記事項_デザイン(7, "DBE221061_ChosahyoIraishoAssortment_TokkijikoDesign"),
    認定調査票_特記事項_OCR_表面(8, "DBE221061_ChosahyoIraishoAssortment_TokkijikoOcr_Hyomen"),
    認定調査票_特記事項_OCR_裏面(9, "DBE221061_ChosahyoIraishoAssortment_TokkijikoOcr_Rimen"),
    認定調査票_概況特記_OCR(10, "DBE221061_ChosahyoIraishoAssortment_GaikyoTokkiOcr"),
    認定調査票_特記事項_項目有り(11, "DBE221061_ChosahyoIraishoAssortment_Tokkijiko_KomokuAri"),
    認定調査票_特記事項_項目有り_手入力(12, "DBE221061_ChosahyoIraishoAssortment_Tokkijiko_KomokuAri_OCR"),
    認定調査票_特記事項_項目無し(13, "DBE221061_ChosahyoIraishoAssortment_Tokkijiko_KomokuNashi"),
    認定調査票_特記事項_項目無し_手入力(14, "DBE221061_ChosahyoIraishoAssortment_Tokkijiko_KomokuNashi_OCR"),
    認定調査票_特記事項_フリー様式(15, "DBE221061_ChosahyoIraishoAssortment_TokkijikoFree"),
    認定調査票_特記事項_OCR_フリー様式(16, "DBE221061_ChosahyoIraishoAssortment_TokkijikoFree_OCR"),
    認定調査票_空白ページ(17, "DBE221061_ChosahyoIraishoAssortment_BlankPage");
    
    /**
     * FormGroupIndexです。
     */
    public int index;
    
    /**
     * FormGroupIdです。
     */
    public RString key;
    private ChosahyoMatomeLayout(int index, String key) {
        this.index = index;
        this.key = new RString(key);
    }
    
    /**
     * FormGroupIdの一覧を取得します。
     * @return List<RString>
     */
    public static List<RString> getKeys() {
        List<RString> list = new ArrayList<>();
        for (ChosahyoMatomeLayout item : ChosahyoMatomeLayout.values()) {
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
