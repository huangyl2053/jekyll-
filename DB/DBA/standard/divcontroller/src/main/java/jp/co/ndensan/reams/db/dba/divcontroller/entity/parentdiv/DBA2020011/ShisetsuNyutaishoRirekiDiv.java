package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuNyutaishoRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuNyutaishoRirekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShisetsuNyutaishoMeisai")
    private ShisetsuNyutaishoMeisaiDiv ShisetsuNyutaishoMeisai;
    @JsonProperty("ccdShisetsuNyutaishoRirekiKanri")
    private ShisetsuNyutaishoRirekiKanriDiv ccdShisetsuNyutaishoRirekiKanri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShisetsuNyutaishoMeisai")
    public ShisetsuNyutaishoMeisaiDiv getShisetsuNyutaishoMeisai() {
        return ShisetsuNyutaishoMeisai;
    }

    @JsonProperty("ShisetsuNyutaishoMeisai")
    public void setShisetsuNyutaishoMeisai(ShisetsuNyutaishoMeisaiDiv ShisetsuNyutaishoMeisai) {
        this.ShisetsuNyutaishoMeisai=ShisetsuNyutaishoMeisai;
    }

    @JsonProperty("ccdShisetsuNyutaishoRirekiKanri")
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRirekiKanri() {
        return ccdShisetsuNyutaishoRirekiKanri;
    }

    // </editor-fold>
}
