/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.codeassigneditem;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.ICodeValueObject;

/**
 * 取得事由（除外適用）のコードマスタ情報を表すクラスです。
 *
 * @author N9606 漢那 憲作
 */
public class ShutokuJiyuJogaiTekiyo implements ICodeValueObject {

    private final Code code;
    private final RString codeMeisho;
    private final RString codeRyakusho;
    private final RString option1;
    private final RString option2;
    private final RString option3;

    /**
     * コンストラクタです。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     * @param option1 任意情報1
     * @param option2 任意情報2
     * @param option3 任意情報3
     */
    public ShutokuJiyuJogaiTekiyo(Code code, RString codeMeisho, RString codeRyakusho, RString option1, RString option2, RString option3) {
        this.code = code;
        this.codeMeisho = codeMeisho;
        this.codeRyakusho = codeRyakusho;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    /**
     * 任意情報を指定しないパターンのコンストラクタです。<br />
     * 任意情報の設定が不要な場合、こちらを使用してください。
     *
     * @param code コード
     * @param codeMeisho コード名称
     * @param codeRyakusho コード略称
     */
    public ShutokuJiyuJogaiTekiyo(Code code, RString codeMeisho, RString codeRyakusho) {
        this(code, codeMeisho, codeRyakusho, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    @Override
    public RString toRString() {
        return code.value();
    }

    @Override
    public RString getMeisho() {
        return codeMeisho;
    }

    @Override
    public RString getMeisho(FlexibleDate fd) {
        return codeMeisho;
    }

    @Override
    public RString getRyakusho() {
        return codeRyakusho;
    }

    @Override
    public RString getRyakusho(FlexibleDate fd) {
        return codeRyakusho;
    }

    public RString getOption1() {
        return option1;
    }

    public RString getOption2() {
        return option2;
    }

    public RString getOption3() {
        return option3;
    }

}
