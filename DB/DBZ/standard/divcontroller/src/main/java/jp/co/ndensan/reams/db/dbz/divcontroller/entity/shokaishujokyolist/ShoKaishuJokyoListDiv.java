package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.IShoKaishuJokyoListDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShoKaishuJokyoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoKaishuJokyoListDiv extends Panel implements IShoKaishuJokyoListDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShoKaishuJokyo")
    private DataGrid<dgShoKaishuJokyo_Row> dgShoKaishuJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShoKaishuJokyo")
    public DataGrid<dgShoKaishuJokyo_Row> getDgShoKaishuJokyo() {
        return dgShoKaishuJokyo;
    }

    @JsonProperty("dgShoKaishuJokyo")
    public void setDgShoKaishuJokyo(DataGrid<dgShoKaishuJokyo_Row> dgShoKaishuJokyo) {
        this.dgShoKaishuJokyo=dgShoKaishuJokyo;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

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
        return (グリッド表示モード) _CommonChildDivModeUtil.getMode( this.modes, グリッド表示モード.class );
    }

    public void setMode_グリッド表示モード( グリッド表示モード value ) {
        _CommonChildDivModeUtil.setMode( this.modes, グリッド表示モード.class , value );
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
        return (一覧パネル高さ) _CommonChildDivModeUtil.getMode( this.modes, 一覧パネル高さ.class );
    }

    public void setMode_一覧パネル高さ( 一覧パネル高さ value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 一覧パネル高さ.class , value );
    }

    //--------------- この行より下にコードを追加してください -------------------

}
