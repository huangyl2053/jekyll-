package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IAtenaSearchKey;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoAtenaInfo のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoAtenaInfoDiv extends Panel implements IKaigoAtenaInfoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("atenaInfo")
    private AtenaShokaiSimpleDiv atenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getatenaInfo
     * @return atenaInfo
     */
    @JsonProperty("atenaInfo")
    public IAtenaShokaiSimpleDiv getAtenaInfo() {
        return atenaInfo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 介護宛名基本情報の初期化
     *
     * @param iask 宛名検索キー
     */
    @Override
    public void onLoad(IAtenaSearchKey iask) {
        getAtenaInfo().load(iask);
        getAtenaInfo().onChangeDisplayMode三行タイプ();
    }

}
