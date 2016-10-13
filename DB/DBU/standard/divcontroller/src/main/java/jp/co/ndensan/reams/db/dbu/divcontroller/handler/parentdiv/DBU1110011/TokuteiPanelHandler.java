/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU1110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameterHandler;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohoMeisho;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011.TokuteiPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011.grdTokuteiJoho_Row;

/**
 * 個人番号関連情報提供のHandlerクラスです。
 *
 * @reamsid_L DBU-4880-010 linghuhang
 */
public class TokuteiPanelHandler {

    private final TokuteiPanelDiv div;
    private static final int 版番号カウント件数 = 0;

    /**
     * コンストラクタです。
     *
     * @param div 個人番号関連情報提供Div
     */
    public TokuteiPanelHandler(TokuteiPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化を表示します。
     *
     * @param 版番号カウント 版番号カウント
     */
    public void onLoad(int 版番号カウント) {
        set一覧(版番号カウント);
    }

    /**
     * パラーメタを設定します。
     *
     * @return DBU080010_TokuteiKojinJohoTeikyoParameter
     */
    public DBU080010_TokuteiKojinJohoTeikyoParameter onClick_btnBatchParamSave() {
        // TODO 凌護行 画面項目とバッチパラメータの対応は、
//        設計書「バッチ設計_DBUMNC2001-1_特定個人情報提供」のバッチパラメータシート
//        （画面起動時（ワークフローID = xxxxxx）を参照。
//        QA1818_#103726
        List<DBU080010_TokuteiKojinJohoTeikyoParameterHandler> 特定個人情報 = new ArrayList<>();
        DBU080010_TokuteiKojinJohoTeikyoParameter parameter = new DBU080010_TokuteiKojinJohoTeikyoParameter();
        List<grdTokuteiJoho_Row> listRow = div.getGrdTokuteiJoho().getDataSource();
        for (grdTokuteiJoho_Row row : listRow) {
            if (row.getChkSeiGyo().isValue()) {
                DBU080010_TokuteiKojinJohoTeikyoParameterHandler parameterHandler
                        = new DBU080010_TokuteiKojinJohoTeikyoParameterHandler();
                parameterHandler.set特定個人情報名コード(row.getTokuteiKojinJohoNo());
                特定個人情報.add(parameterHandler);
            }
        }
        parameter.set特定個人情報(特定個人情報);
        return parameter;
    }

    private void set一覧(int 版番号カウント) {
        List<grdTokuteiJoho_Row> listRow = new ArrayList<>();
        for (TokuteiKojinJohoMeisho tokuteiKojin : TokuteiKojinJohoMeisho.values()) {
            grdTokuteiJoho_Row row = new grdTokuteiJoho_Row();
            if (版番号カウント == 版番号カウント件数) {
                row.getChkSeiGyo().setDisabled(true);
            }
            row.setTokuteiKojinJohoNo(tokuteiKojin.getコード());
            row.setTokuteiKojinJoho(tokuteiKojin.get名称());
            listRow.add(row);
        }
        div.getGrdTokuteiJoho().setDataSource(listRow);
    }
}
