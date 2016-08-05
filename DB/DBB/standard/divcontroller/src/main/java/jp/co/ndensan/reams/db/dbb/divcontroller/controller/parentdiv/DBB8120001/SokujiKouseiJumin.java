/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8120001;

import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiKouseiJuminDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranparameter.IdoTaishoshaIchiranparameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey.Builder;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM13001_2_即時賦課更正のクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiKouseiJumin {

    private static final RString メニューID_通知書発行後異動把握 = new RString("DBBMN32001");
    private static final RString メニューID_特徴仮算定賦課エラー一覧 = new RString("DBBMN33004");
    private static final RString メニューID_即時賦課更正 = new RString("DBBMN13001");

    /**
     * 画面の初期化メソッドです。
     *
     * @param sokujiKouseiJuminDiv SokujiKouseiJuminDiv
     * @return 画面のResponseData
     */
    public ResponseData<SokujiKouseiJuminDiv> onLoad_SokujiKouseiJumin(SokujiKouseiJuminDiv sokujiKouseiJuminDiv) {
        FlexibleYear 賦課年度 = null;
        TsuchishoNo 通知書番号 = null;
        ShikibetsuCode 識別コード = null;
        LasdecCode 市町村コード = null;
        RString メニューID = ResponseHolder.getMenuID();
        if (メニューID_通知書発行後異動把握.equals(メニューID)) {
            IdoTaishoshaIchiranparameter 異動者一覧Par = ViewStateHolder.get(ViewStateKeys.異動者一覧Par, IdoTaishoshaIchiranparameter.class);
            賦課年度 = 異動者一覧Par.getFukaNendo();
            通知書番号 = 異動者一覧Par.getTsuchishoNo();
            識別コード = 異動者一覧Par.getShikibetsuCode();
        } else if (メニューID_特徴仮算定賦課エラー一覧.equals(メニューID)) {
            FukaErrorList 賦課エラー情報 = ViewStateHolder.get(ViewStateKeys.賦課エラー情報, FukaErrorList.class);
            賦課年度 = 賦課エラー情報.get賦課年度();
            通知書番号 = 賦課エラー情報.get通知書番号();
            識別コード = 賦課エラー情報.get識別コード();
        } else if (メニューID_即時賦課更正.equals(メニューID)) {
            FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
            賦課年度 = 賦課対象者.get賦課年度();
            通知書番号 = 賦課対象者.get通知書番号();
            識別コード = 賦課対象者.get識別コード();
            市町村コード = 賦課対象者.get市町村コード();
        }
        KaigoFukaKihonSearchKey 介護賦課基本情報の検索キー = new Builder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
        sokujiKouseiJuminDiv.getCcdSokujiKouseiKihon().load(介護賦課基本情報の検索キー);
        sokujiKouseiJuminDiv.getSokujiKouseiAtena().initialize(識別コード);
        return ResponseData.of(sokujiKouseiJuminDiv).respond();
    }
}
