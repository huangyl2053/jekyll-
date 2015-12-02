/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe9020001;

import jp.co.ndensan.reams.db.dbe.divcontroller.controller.handler.dbe9020001.ShujiiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiDiv;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 主治医マスタDivの処理を表します。
 *
 * @author N1013
 */
public class Shujii {

    /**
     * 主治医マスタDivの画面初期化を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onLoad(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();
	getHandler(div).onLoad();
	response.data = div;
	return response;
    }

    /**
     * 主治医マスタDivの検索を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnSearchShujii(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	getHandler(div).btnSearchShujii(null);
	response.data = div;
	return response;
    }

    /**
     * 主治医マスタDivの条件をクリアを表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnClearKensakuJoken(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 主治医マスタDivの追加を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnInsert(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	getHandler(div).btnInsert();
	response.data = div;
	return response;
    }

    /**
     * 主治医マスタDivの修正を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnUpdate(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 主治医マスタDivの削除を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnDelete(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 主治医一覧 行選択を表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnRowSelection(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * ＣＳＶを出力するを表します。
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnOutputCsv(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 市町村名を取得する
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onblur_get市町村名(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	IAssociationFinder finder = AssociationFinderFactory.createInstance();
	Association association = finder.getAssociation(new LasdecCode("000001"));
	//div.getShujiiJoholnput().getTextBoxCode5().setValue(association.get市町村名());

	response.data = div;
	return response;
    }

    /**
     * 市町村検索ボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnToSearchShichoson(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 主治医医療機関名を取得する
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onblur_get主治医医療機関名(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 主治医医療機関検索ボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData btnToSearchIryoKikan(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 取消ボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnTorikeshi(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 確定ボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnKakutei(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 医療機関登録へ戻るボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnBack(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    /**
     * 保存ボタン処理です
     *
     * @param div 主治医マスタDiv
     * @return ResponseData
     */
    public ResponseData onClick_btnSave(ShujiiDiv div) {
	ResponseData<ShujiiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

    private ShujiiHandler getHandler(ShujiiDiv div) {
	return new ShujiiHandler(div);
    }
}
