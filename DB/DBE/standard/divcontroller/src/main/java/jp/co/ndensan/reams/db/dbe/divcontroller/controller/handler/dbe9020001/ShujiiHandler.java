/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.handler.dbe9020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho.ShujiiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.DataGrid1_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiDiv;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shujiijoho.ShujiiJohoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author soft863
 */
public class ShujiiHandler {

    private final ShujiiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医マスタDiv
     */
    public ShujiiHandler(ShujiiDiv div) {
	this.div = div;
    }

    public void onLoad() {
	ShujiiIryokikanCode shujiiIryokikanCode = new ShujiiIryokikanCode(new RString("12"));
	if ("12".equals(shujiiIryokikanCode)) {
	    ShujiiJohoMapperParameter param = ShujiiJohoMapperParameter.createSelectByKeyParam(LasdecCode.EMPTY, true, shujiiIryokikanCode, shujiiIryokikanCode, RString.EMPTY, RString.EMPTY, ShujiiCode.EMPTY, ShujiiCode.EMPTY, RString.EMPTY, AtenaKanaMeisho.EMPTY);
	    this.btnSearchShujii(param);
	} else {
	    this.clearKensakuJoken();
	}
	div.getShujiilchiran().isVisible(); //TODO
	div.getShujiiJoholnput().isVisible();//TODO
    }

    /**
     * 検索処理です。
     *
     * @param param
     */
    public void btnSearchShujii(ShujiiJohoMapperParameter param) {
	ShujiiJohoManager shujiiJohoManager = ShujiiJohoManager.createInstance();
	List<ShujiiJoho> list = shujiiJohoManager.get主治医情報(param);
	if (list.isEmpty()) {
	    throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
	}
	List<DataGrid1_Row> dataList = new ArrayList();
	for (ShujiiJoho shujiiJoho : list) {
	    DataGrid1_Row row = new DataGrid1_Row();
	    row.setShichoson(shujiiJoho.getShichosonMeisho());
	    row.setShujiiShimei(shujiiJoho.getShujiiName().getColumnValue());
	    row.setShujiiKanaShimei(shujiiJoho.getShujiiKana().getColumnValue());
	    row.getShujiiCode().setValue(shujiiJoho.getShujiiCode().getColumnValue());
	    row.getShujiiIryoKikanCode().setValue(shujiiJoho.getShujiiIryokikanCode().getColumnValue());
	    row.setShujiiIryoKikan(shujiiJoho.getIryoKikanMeisho());
	    row.setShinryoka(shujiiJoho.getShinryokaName());
	    row.setShiteii(RString.EMPTY);
	    row.setJokyoFlag(RString.EMPTY);
	    row.setYubinNo(shujiiJoho.getYubinNo().getColumnValue());
	    row.setJusho(shujiiJoho.getJusho());
	    row.setTelNo(shujiiJoho.getTelNo().getColumnValue());
	    row.setFaxNo(shujiiJoho.getFaxNo().getColumnValue());
	    dataList.add(row);
	}
	div.getDataGrid1().setDataSource(dataList);
//	row.setShichoson(new RString("123"));
//	row.setShujiiShimei(new RString("456"));
//	row.setShujiiKanaShimei(new RString("789"));
//	row.setShujiiIryoKikan(new RString("012"));
//	row.setShinryoka(new RString("124"));
//	dataList.add(row);
//	div.getDataGrid1().setDataSource(dataList);
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clearKensakuJoken() {

	div.getShujiiSearch().getDropDownList1().setDataSource(null);
	div.getShujiiSearch().getTextBox1().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBox2().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxCode1().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxCode2().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxCode3().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxCode4().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxKana1().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxKana2().setValue(RString.EMPTY);
	div.getShujiiSearch().getTextBoxNum1().setValue(Decimal.ZERO);
	//div.getRadioButton1()
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void btnInsert() {

	div.getShujiiJoholnput().setVisible(true);
	div.getShujiiSearch().setDisabled(true);
	div.getShujiilchiran().setDisabled(true);
	div.getShujiiJoholnput().getTextBox3().setValue(RString.EMPTY);
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void btnUpdate() {

	div.getShujiiJoholnput().setVisible(true);
	div.getShujiiSearch().setDisabled(true);
	div.getShujiilchiran().setDisabled(true);

    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
	div.getDataGrid1().getDataSource().clear();
    }

}
