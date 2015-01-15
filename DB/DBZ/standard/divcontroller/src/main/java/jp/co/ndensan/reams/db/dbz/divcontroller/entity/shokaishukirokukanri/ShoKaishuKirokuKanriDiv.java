package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.IShoKaishuJokyoListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyoshosai.IShoKaishuJokyoShosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyoshosai.ShoKaishuJokyoShosaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.model.shokofukaishu.ShoKofuKaishuModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShoKaishuKirokuKanri のクラスファイル
 *
 * @author 自動生成
 */
public class ShoKaishuKirokuKanriDiv extends Panel implements IShoKaishuKirokuKanriDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdShoKaishuJokyoList")
    private ShoKaishuJokyoListDiv ccdShoKaishuJokyoList;
    @JsonProperty("ccdShoKaishuJokyoShosai")
    private ShoKaishuJokyoShosaiDiv ccdShoKaishuJokyoShosai;
    @JsonProperty("btnShoKaishuKakutei")
    private Button btnShoKaishuKakutei;
    @JsonProperty("btnShoKaishuTorikeshi")
    private Button btnShoKaishuTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdShoKaishuJokyoList")
    public IShoKaishuJokyoListDiv getCcdShoKaishuJokyoList() {
        return ccdShoKaishuJokyoList;
    }

    @JsonProperty("ccdShoKaishuJokyoShosai")
    public IShoKaishuJokyoShosaiDiv getCcdShoKaishuJokyoShosai() {
        return ccdShoKaishuJokyoShosai;
    }

    @JsonProperty("btnShoKaishuKakutei")
    public Button getBtnShoKaishuKakutei() {
        return btnShoKaishuKakutei;
    }

    @JsonProperty("btnShoKaishuKakutei")
    public void setBtnShoKaishuKakutei(Button btnShoKaishuKakutei) {
        this.btnShoKaishuKakutei = btnShoKaishuKakutei;
    }

    @JsonProperty("btnShoKaishuTorikeshi")
    public Button getBtnShoKaishuTorikeshi() {
        return btnShoKaishuTorikeshi;
    }

    @JsonProperty("btnShoKaishuTorikeshi")
    public void setBtnShoKaishuTorikeshi(Button btnShoKaishuTorikeshi) {
        this.btnShoKaishuTorikeshi = btnShoKaishuTorikeshi;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 表示方法 implements ICommonChildDivMode {

        照会("照会"),
        入力("入力"),
        非表示("非表示");

        private final String name;

        private 表示方法(final String name) {
            this.name = name;
        }

        public static 表示方法 getEnum(String str) {
            表示方法[] enumArray = 表示方法.values();

            for (表示方法 enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public 表示方法 getMode_表示方法() {
        return (表示方法) _CommonChildDivModeUtil.getMode(this.modes, 表示方法.class);
    }

    public void setMode_表示方法(表示方法 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示方法.class, value);
    }

    public static enum グリッド表示モード implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku"),
        select("select");

        private final String name;

        private グリッド表示モード(final String name) {
            this.name = name;
        }

        public static グリッド表示モード getEnum(String str) {
            グリッド表示モード[] enumArray = グリッド表示モード.values();

            for (グリッド表示モード enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public グリッド表示モード getMode_グリッド表示モード() {
        return (グリッド表示モード) _CommonChildDivModeUtil.getMode(this.modes, グリッド表示モード.class);
    }

    public void setMode_グリッド表示モード(グリッド表示モード value) {
        _CommonChildDivModeUtil.setMode(this.modes, グリッド表示モード.class, value);
    }

    public static enum 一覧パネル高さ implements ICommonChildDivMode {

        サイズ200("サイズ200"),
        サイズ250("サイズ250"),
        サイズ300("サイズ300"),
        サイズ350("サイズ350"),
        サイズ400("サイズ400"),
        サイズ450("サイズ450"),
        サイズ500("サイズ500");

        private final String name;

        private 一覧パネル高さ(final String name) {
            this.name = name;
        }

        public static 一覧パネル高さ getEnum(String str) {
            一覧パネル高さ[] enumArray = 一覧パネル高さ.values();

            for (一覧パネル高さ enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public 一覧パネル高さ getMode_一覧パネル高さ() {
        return (一覧パネル高さ) _CommonChildDivModeUtil.getMode(this.modes, 一覧パネル高さ.class);
    }

    public void setMode_一覧パネル高さ(一覧パネル高さ value) {
        _CommonChildDivModeUtil.setMode(this.modes, 一覧パネル高さ.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード, SubGyomuCode サブ業務コード) {
        //TODO
        //1)、引数から渡されたキーを元に、証交付回収情報を取得する。
        //2)、取得した証交付回収履歴ListをPanelSessionAccessorに登録する。
        //3)、取得した証交付回収履歴Listを、グリッドにマッピングする。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearInputData() {
        //TODO
        //1)、入力明細パネル上のコントロールに対して、空白やnullなどを設定する。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemList<ShoKofuKaishuModel> get証交付回収履歴() {
        //TODO
        //1),PanelSessionAccessorに登録されている情報を取得し、戻り値として返却する。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set証交付回収履歴(IItemList<ShoKofuKaishuModel> 証交付回収履歴List) {
        //TODO
        //1)、引数から渡された情報を、PanelSessionAccessorに登録する。
        //2)、登録した情報を、グリッドにマッピングする。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
