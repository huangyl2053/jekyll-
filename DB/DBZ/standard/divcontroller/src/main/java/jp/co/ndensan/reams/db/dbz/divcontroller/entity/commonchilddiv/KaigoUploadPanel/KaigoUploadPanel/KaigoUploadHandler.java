/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoUploadPanel.KaigoUploadPanel;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * アップロードダイアログのハンドラークラスです。
 *
 * @reamsid_L DBZ-4530-010 houtianpeng
 */
public class KaigoUploadHandler {

    private final KaigoUploadPanelDiv div;
    private final RString 単一モード = new RString("単一モード");
    private final RString 複数モード = new RString("複数モード");

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public KaigoUploadHandler(KaigoUploadPanelDiv div) {
        this.div = div;
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param 処理モード
     */
    public void initialize(RString 処理モード) {

        if (処理モード.equals(単一モード)) {

            div.setMode_IsSimpleMode(KaigoUploadPanelDiv.IsSimpleMode.TRUE);
            div.getLblUploadFileName().setText(DataPassingConverter.deserialize(div.getファイル名称(), RString.class));
        }
        if (処理モード.equals(複数モード)) {

            div.setMode_IsSimpleMode(KaigoUploadPanelDiv.IsSimpleMode.FALSE);
            div.getLblUploadFileName().setDisplayNone(true);
            div.getLblFileName().setDisplayNone(true);
        }
    }

    /**
     * 「閉じる」ボタン。
     *
     */
    public void toJiRu() {

        div.getBtnClose().setVisible(false);
    }

    /**
     * ファイル名称を設定します。
     *
     * @param ファイル名称
     */
    public void setファイル名称(RString ファイル名称) {

        div.setファイル名称(ファイル名称);
    }

    /**
     * 出力先フォルダを設定します。
     *
     * @param 出力先フォルダ
     */
    public void set出力先フォルダ(RString 出力先フォルダ) {

        div.set出力先フォルダ(出力先フォルダ);
    }
}
