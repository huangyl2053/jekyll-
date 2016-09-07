package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IStateEnumerations;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD5120001の状態名定義クラスです
 *
 * @author 自動生成
 */
public enum DBD5120001StateName implements IStateEnumerations {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    NoChange(""),
    申請追加("申請追加"),
    申請修正("申請修正"),
    申請取下("申請取下"),
    区分変更追加("区分変更追加"),
    区分変更修正("区分変更修正"),
    区分変更取下("区分変更取下"),
    サービス変更追加("サービス変更追加"),
    サービス変更修正("サービス変更修正"),
    サービス変更取下("サービス変更取下"),
    受給者転入追加("受給者転入追加"),
    職権記載("職権記載"),
    職権全喪失("職権全喪失"),
    新規完了("新規完了"),
    削除修正完了("削除修正完了"),
    特殊追加("特殊追加"),
    特殊修正("特殊修正"),
    特殊削除("特殊削除"),
    削除回復("削除回復");

    private final RString name;

    private DBD5120001StateName(String name) {
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
