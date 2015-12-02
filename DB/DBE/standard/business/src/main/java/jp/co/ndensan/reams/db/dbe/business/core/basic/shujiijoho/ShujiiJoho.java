/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic.shujiijoho;

import jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho.ShujiiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報クラスです。
 */
public class ShujiiJoho {

    private final ShujiiJohoRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 主治医情報Entity
     */
    public ShujiiJoho(ShujiiJohoRelateEntity entity) {
	this.entity = entity;
    }

    public LasdecCode getShichosonCode() {
	return entity.getShichosonCode();
    }

    public AtenaMeisho getShujiiName() {
	return entity.getShujiiName();
    }

    public AtenaKanaMeisho getShujiiKana() {
	return entity.getShujiiKana();
    }

    public ShujiiCode getShujiiCode() {
	return entity.getShujiiCode();
    }

    public RString getShinryokaName() {
	return entity.getShinryokaName();
    }

    public boolean isShiteiiFlag() {
	return entity.isShiteiiFlag();
    }

    public boolean isJokyoFlag() {
	return entity.isJokyoFlag();
    }

    public YubinNo getYubinNo() {
	return entity.getYubinNo();
    }

    public RString getJusho() {
	return entity.getJusho();
    }

    public TelNo getTelNo() {
	return entity.getTelNo();
    }

    public TelNo getFaxNo() {
	return entity.getFaxNo();
    }

    public Code getSeibetsu() {
	return entity.getSeibetsu();
    }

    public RString getShichosonMeisho() {
	return entity.getShichosonMeisho();
    }

    public ShujiiIryokikanCode getShujiiIryokikanCode() {
	return entity.getShujiiIryokikanCode();
    }

    public RString getIryoKikanMeisho() {
	return entity.getIryoKikanMeisho();
    }

}
