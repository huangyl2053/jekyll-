/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * <p>
 * <h3>機能説明</h3>
 * コードマスタから取得した値によって構成されるクラスのベースクラスです。
 * </p>
 * <p>
 * <h3>利用方法</h3>
 * このクラスを継承して、コードマスタで管理している項目を表現するクラスを作成してください。<br />
 * 例えば、職業をコードマスタで管理する場合、このクラスを継承したJobクラスを作成してください。
 * </p>
 * <hr/>
 *
 * @author N3137 倉田 伸吾
 * @jpName コードマスタベースクラス
 * @bizDomain 業務共通_コア
 * @category コードマスタ
 * @subCategory
 * @mainClass
 * @reference
 * @deprecated n3137倉田
 * このクラスは廃止される。{@link jp.co.ndensan.reams.uz.uza.util.code.ICodeValueObject}の実装クラスを使用するよう修正すること。どこからも参照されなくなったら削除する。
 */
public abstract class CodeAssignedItem implements Serializable {

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
    public CodeAssignedItem(Code code, RString codeMeisho, RString codeRyakusho, RString option1, RString option2, RString option3) {
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
    public CodeAssignedItem(Code code, RString codeMeisho, RString codeRyakusho) {
        this(code, codeMeisho, codeRyakusho, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public Code getCode() {
        return code;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getMeisho() {
        return codeMeisho;
    }

    /**
     * 略称を返します。
     *
     * @return 略称
     */
    public RString getRyakusho() {
        return codeRyakusho;
    }

    /**
     * 任意情報1を返します。
     * <p>
     * 当メソッドは外部には公開しません。<br />
     * このクラスを継承するクラスにて、何が返るかがメソッド名から明確になるメソッドを実装し、内部では当メソッドに委譲して任意情報1の値を返してください。<br
     * />
     * 例えば、コードマスタで職業を管理していて、任意情報1では職業の英語表記を保持している場合、このクラスを継承した職業クラスでは
     * {@code get英語表記()} メソッドを定義し、戻り値には {@code getOption1()} の戻り値を返す実装としてください。
     * </p>
     *
     * @return 任意情報1
     */
    protected RString getOption1() {
        return option1;
    }

    /**
     * 任意情報2を返します。
     * <p>
     * 当メソッドは外部には公開しません。<br /> {@code getOption1()} と同様に使用してください。
     * </p>
     *
     * @return 任意情報2
     */
    protected RString getOption2() {
        return option2;
    }

    /**
     * 任意情報3を返します。
     * <p>
     * 当メソッドは外部には公開しません。<br /> {@code getOption1()} と同様に使用してください。
     * </p>
     *
     * @return 任意情報3
     */
    protected RString getOption3() {
        return option3;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.code);
        hash = 67 * hash + Objects.hashCode(this.codeMeisho);
        hash = 67 * hash + Objects.hashCode(this.codeRyakusho);
        hash = 67 * hash + Objects.hashCode(this.option1);
        hash = 67 * hash + Objects.hashCode(this.option2);
        hash = 67 * hash + Objects.hashCode(this.option3);
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
        final CodeAssignedItem other = (CodeAssignedItem) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.codeMeisho, other.codeMeisho)) {
            return false;
        }
        if (!Objects.equals(this.codeRyakusho, other.codeRyakusho)) {
            return false;
        }
        if (!Objects.equals(this.option1, other.option1)) {
            return false;
        }
        if (!Objects.equals(this.option2, other.option2)) {
            return false;
        }
        if (!Objects.equals(this.option3, other.option3)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CodeAssignedItem{" + "code=" + code + ", codeMeisho=" + codeMeisho + ", codeRyakusho=" + codeRyakusho
                + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + '}';
    }
}
