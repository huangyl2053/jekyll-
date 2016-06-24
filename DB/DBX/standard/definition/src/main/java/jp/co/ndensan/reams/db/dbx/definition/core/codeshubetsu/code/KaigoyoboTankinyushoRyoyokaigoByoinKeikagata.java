/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.code;

import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBXCodeShubetsu;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.util.code.ICodeValueObject;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護予防短期入所療養介護_病院経過型を表すドメインクラスです。
 *
 * @author n3317 塚田 萌
 * @jpName 介護予防短期入所療養介護_病院経過型
 * @bizDomain
 * @category CodeValueObject
 * @subCategory
 * @mainClass
 * @reference
 */
public class KaigoyoboTankinyushoRyoyokaigoByoinKeikagata implements ICodeValueObject, IDbColumnMappable, IValueObject<Code> {

    /**
     * URZ業務共通を表すサブ業務コードです。
     */
    public static final SubGyomuCode SUB_GYOMU_CODE;
    /**
     * 介護予防短期入所療養介護_病院経過型を表すコード種別です。
     */
    public static final CodeShubetsu CODE_SHUBETSU;

    private final Code code;

    static {
        SUB_GYOMU_CODE = SubGyomuCode.DBX介護公開;
        CODE_SHUBETSU = DBXCodeShubetsu.介護予防短期入所療養介護_病院経過型.getCodeShubetsu();
    }

    /**
     * コンストラクタです。
     *
     * @param code 介護予防短期入所療養介護_病院経過型
     */
    public KaigoyoboTankinyushoRyoyokaigoByoinKeikagata(Code code) {
        this.code = code;
    }

    /**
     * コンストラクタです。
     *
     * @param code 介護予防短期入所療養介護_病院経過型を表す文字列
     */
    public KaigoyoboTankinyushoRyoyokaigoByoinKeikagata(RString code) {
        this.code = new Code(code);
    }

    @Override
    public RString toRString() {
        return code == null ? RString.EMPTY : code.value();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KaigoyoboTankinyushoRyoyokaigoByoinKeikagata other = (KaigoyoboTankinyushoRyoyokaigoByoinKeikagata) obj;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public String toString() {
        return toRString().toString();
    }

    @Override
    public Code value() {
        return code;
    }

    @Override
    public RString getColumnValue() {
        return value().getColumnValue();
    }

    @Override
    public RString getMeisho() {
        return code == null ? RString.EMPTY : CodeMaster.getCodeMeisho(SUB_GYOMU_CODE, CODE_SHUBETSU, code);
    }

    @Override
    public RString getMeisho(FlexibleDate kijunbi) {
        return code == null ? RString.EMPTY : CodeMaster.getCodeMeisho(SUB_GYOMU_CODE, CODE_SHUBETSU, code, kijunbi);
    }

    @Override
    public RString getRyakusho() {
        return code == null ? RString.EMPTY : CodeMaster.getCodeRyakusho(SUB_GYOMU_CODE, CODE_SHUBETSU, code);
    }

    @Override
    public RString getRyakusho(FlexibleDate kijunbi) {
        return code == null ? RString.EMPTY : CodeMaster.getCodeRyakusho(SUB_GYOMU_CODE, CODE_SHUBETSU, code, kijunbi);
    }
}
