/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic.shujiijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho.ShujiiMasterRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報を管理するクラスです。
 */
public class ShujiiMaster {

    private final ShujiiMasterRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ShujiiMasterRelateEntity}より{@link ShujiiJoho}を生成します。
     *
     * @param entity DBより取得した{@link ShujiiMasterRelateEntity}
     */
    public ShujiiMaster(ShujiiMasterRelateEntity entity) {
	this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報"));
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

    public RString getShujiiCode() {
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

    public RString getShujiiIryokikanCode() {
	return entity.getShujiiIryokikanCode();
    }

    public RString getIryoKikanMeisho() {
	return entity.getIryoKikanMeisho();
    }

}
