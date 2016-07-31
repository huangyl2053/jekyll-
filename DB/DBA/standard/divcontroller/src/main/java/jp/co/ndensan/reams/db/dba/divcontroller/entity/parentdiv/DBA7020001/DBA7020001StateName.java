package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA7020001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBA7020001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    適用除外者("適用除外者"),
    他市町村住所地特例者("他市町村住所地特例者"),
    老齢福祉年金受給者("老齢福祉年金受給者"),
    生活保護受給者("生活保護受給者");

    private final RString name;

    private DBA7020001StateName(String name) {
        this.name = new RString(name);
    }

    /**
     * getName
     *
     * @return 名前
     */
    @Override
    public RString getName() {
        return name;
    }
// </editor-fold>
}
