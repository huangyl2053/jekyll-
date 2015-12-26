/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.shichosonlist;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村EntiyのBusinessクラスです。
 */
public final class ShichosonCodeNameResult implements Serializable {

    /**
     * 空を表す{@link ShichosonCodeNameResult} です。
     * <p/>
     * 各メソッドの返却値は以下の通りです。
     * <ul>
     * <li>市町村コード…{@link LasdecCode#EMPTY}</li>
     * <li>市町村名…{@link RString#EMPTY}</li>
     * <li>証記載保険者番号…{@link ShoKisaiHokenshaNo#EMPTY}</li>
     * <li>保険者区分…{@link TokeiTaishoKubun#空}</li>
     * </ul>
     */
    public static final ShichosonCodeNameResult EMPTY;

    static {
        EMPTY = new ShichosonCodeNameResult();
    }

    private static final long serialVersionUID = -755396991214374692L;

    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final TokeiTaishoKubun 保険者区分;

    /**
     * {@link #EMPTY}用のコンストラクタです。
     */
    private ShichosonCodeNameResult() {
        this.市町村コード = LasdecCode.EMPTY;
        this.市町村名称 = RString.EMPTY;
        this.証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        this.保険者区分 = TokeiTaishoKubun.空;
    }

    /**
     * 市町村EntiyのBusinessクラス作成処理
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 保険者番号 証記載保険者番号
     * @param 保険者区分 保険者区分
     */
    public ShichosonCodeNameResult(LasdecCode 市町村コード, RString 市町村名称, ShoKisaiHokenshaNo 保険者番号, TokeiTaishoKubun 保険者区分) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.証記載保険者番号 = 保険者番号;
        this.保険者区分 = 保険者区分;
    }

    /**
     * 市町村コードを取得する。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 市町村名称を取得する。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return 市町村名称;
    }

    /**
     * 保険者コードを取得する。
     *
     * @return 保険者コード
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 保険者区分を取得する。
     *
     * @return 保険者区分
     */
    public TokeiTaishoKubun get保険者区分() {
        return 保険者区分;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.市町村コード);
        hash = 41 * hash + Objects.hashCode(this.市町村名称);
        hash = 41 * hash + Objects.hashCode(this.証記載保険者番号);
        hash = 41 * hash + Objects.hashCode(this.保険者区分);
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
        final ShichosonCodeNameResult other = (ShichosonCodeNameResult) obj;
        if (!Objects.equals(this.市町村コード, other.市町村コード)) {
            return false;
        }
        if (!Objects.equals(this.市町村名称, other.市町村名称)) {
            return false;
        }
        if (!Objects.equals(this.証記載保険者番号, other.証記載保険者番号)) {
            return false;
        }
        return this.保険者区分 == other.保険者区分;
    }
}
