/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class ShujiiJohoMapperParameter {

    private final boolean shichosonCodeFlag;
    private final boolean jokyoFlag1;
    private final boolean jokyoFlag2;
    private final boolean shujiiIryokikanCodeFromFlag;
    private final boolean shujiiIryokikanCodeToFlag;
    private final boolean iryoKikanMeishoFlag;
    private final boolean iryoKikanMeishoKanaFlag;
    private final boolean shujiiCodeFromFlag;
    private final boolean shujiiCodeToFlag;
    private final boolean shujiiNameFlag;
    private final boolean shujiiKanaFlag;

    private final LasdecCode shichosonCode;
    private final boolean jokyoFlag;
    private final ShujiiIryokikanCode shujiiIryokikanCodeFrom;
    private final ShujiiIryokikanCode shujiiIryokikanCodeTo;
    private final RString iryoKikanMeisho;
    private final RString iryoKikanMeishoKana;
    private final ShujiiCode shujiiCodeFrom;
    private final ShujiiCode shujiiCodeTo;
    private final RString shujiiName;
    private final AtenaKanaMeisho shujiiKana;

    /**
     * コンストラクタです。
     *
     * @param shichonCode shichonCode
     * @param usesshichonCode usesshichonCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShujiiJohoMapperParameter(
	    LasdecCode shichosonCode,
	    boolean jokyoFlag,
	    ShujiiIryokikanCode shujiiIryokikanCodeFrom,
	    ShujiiIryokikanCode shujiiIryokikanCodeTo,
	    RString iryoKikanMeisho,
	    RString iryoKikanMeishoKana,
	    ShujiiCode shujiiCodeFrom,
	    ShujiiCode shujiiCodeTo,
	    RString shujiiName,
	    AtenaKanaMeisho shujiiKana,
	    boolean shichosonCodeFlag,
	    boolean jokyoFlag1,
	    boolean jokyoFlag2,
	    boolean shujiiIryokikanCodeFromFlag,
	    boolean shujiiIryokikanCodeToFlag,
	    boolean iryoKikanMeishoFlag,
	    boolean iryoKikanMeishoKanaFlag,
	    boolean shujiiCodeFromFlag,
	    boolean shujiiCodeToFlag,
	    boolean shujiiNameFlag,
	    boolean shujiiKanaFlag
    ) {
	this.shichosonCode = shichosonCode;
	this.jokyoFlag = jokyoFlag;
	this.shujiiIryokikanCodeFrom = shujiiIryokikanCodeFrom;
	this.shujiiIryokikanCodeTo = shujiiIryokikanCodeTo;
	this.iryoKikanMeisho = iryoKikanMeisho;
	this.iryoKikanMeishoKana = iryoKikanMeishoKana;
	this.shujiiCodeFrom = shujiiCodeFrom;
	this.shujiiCodeTo = shujiiCodeTo;
	this.shujiiName = shujiiName;
	this.shujiiKana = shujiiKana;
	this.shichosonCodeFlag = shichosonCodeFlag;
	this.jokyoFlag1 = jokyoFlag1;
	this.jokyoFlag2 = jokyoFlag2;
	this.shujiiIryokikanCodeFromFlag = shujiiIryokikanCodeFromFlag;
	this.shujiiIryokikanCodeToFlag = shujiiIryokikanCodeToFlag;
	this.iryoKikanMeishoFlag = iryoKikanMeishoFlag;
	this.iryoKikanMeishoKanaFlag = iryoKikanMeishoKanaFlag;
	this.shujiiCodeFromFlag = shujiiCodeFromFlag;
	this.shujiiCodeToFlag = shujiiCodeToFlag;
	this.shujiiNameFlag = shujiiNameFlag;
	this.shujiiKanaFlag = shujiiKanaFlag;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonCode
     * @param jokyoFlag
     * @param shujiiIryokikanCodeFrom
     * @param shujiiIryokikanCodeTo
     * @param iryoKikanMeisho
     * @param iryoKikanMeishoKana
     * @param shujiiCodeFrom
     * @param shujiiCodeTo
     * @param shujiiName
     * @param shujiiKana
     * @return 身体手帳検索パラメータ
     */
    public static ShujiiJohoMapperParameter createSelectByKeyParam(
	    LasdecCode shichosonCode,
	    boolean jokyoFlag,
	    ShujiiIryokikanCode shujiiIryokikanCodeFrom,
	    ShujiiIryokikanCode shujiiIryokikanCodeTo,
	    RString iryoKikanMeisho,
	    RString iryoKikanMeishoKana,
	    ShujiiCode shujiiCodeFrom,
	    ShujiiCode shujiiCodeTo,
	    RString shujiiName,
	    AtenaKanaMeisho shujiiKana) {
	boolean shichosonCodeFlag = true;
	boolean jokyoFlag1 = true;
	boolean jokyoFlag2 = true;
	boolean shujiiIryokikanCodeFromFlag = true;
	boolean shujiiIryokikanCodeToFlag = true;
	boolean iryoKikanMeishoFlag = true;
	boolean iryoKikanMeishoKanaFlag = true;
	boolean shujiiCodeFromFlag = true;
	boolean shujiiCodeToFlag = true;
	boolean shujiiNameFlag = true;
	boolean shujiiKanaFlag = true;

	if (shichosonCode == null || shichosonCode.isEmpty()) {
	    shichosonCodeFlag = false;
	}
	if (jokyoFlag == true) {
	    jokyoFlag2 = false;
	} else {
	    jokyoFlag1 = false;
	}
	if (shujiiIryokikanCodeFrom == null) {
	    shujiiIryokikanCodeFromFlag = false;
	}
	if (shujiiIryokikanCodeTo == null) {
	    shujiiIryokikanCodeToFlag = false;
	}
	if (iryoKikanMeisho == null || iryoKikanMeisho.isEmpty()) {
	    iryoKikanMeishoFlag = false;
	}
	if (iryoKikanMeishoKana == null || iryoKikanMeishoKana.isEmpty()) {
	    iryoKikanMeishoKanaFlag = false;
	}
	if (shujiiCodeFrom == null) {
	    shujiiCodeFromFlag = false;
	}
	if (shujiiCodeTo == null) {
	    shujiiCodeToFlag = false;
	}
	if (shujiiName == null || shujiiName.isEmpty()) {
	    shujiiNameFlag = false;
	}
	if (shujiiKana == null || shujiiKana.isEmpty()) {
	    shujiiKanaFlag = false;
	}
	return new ShujiiJohoMapperParameter(shichosonCode,
		jokyoFlag,
		shujiiIryokikanCodeFrom,
		shujiiIryokikanCodeTo,
		iryoKikanMeisho,
		iryoKikanMeishoKana,
		shujiiCodeFrom,
		shujiiCodeTo,
		shujiiName,
		shujiiKana,
		shichosonCodeFlag,
		jokyoFlag1,
		jokyoFlag2,
		shujiiIryokikanCodeFromFlag,
		shujiiIryokikanCodeToFlag,
		iryoKikanMeishoFlag,
		iryoKikanMeishoKanaFlag,
		shujiiCodeFromFlag,
		shujiiCodeToFlag,
		shujiiNameFlag,
		shujiiKanaFlag
	);
    }

}
