/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担額減額の情報のViewStateクラスです。
 *
 * @reamsid_L DBD-3600-010 xuyue
 */
public class RiyoshaFutangakuGengakuViewState implements Serializable {

    private final RiyoshaFutangakuGengaku joho;
    private final EntityDataState state;
    private final int shorigoRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param joho 業務概念「利用者負担額減額」
     * @param state EntityDataState
     * @param shorigoRirekiNo 履歴番号
     */
    public RiyoshaFutangakuGengakuViewState(RiyoshaFutangakuGengaku joho, EntityDataState state, int shorigoRirekiNo) {
        this.joho = joho;
        this.state = state;
        this.shorigoRirekiNo = shorigoRirekiNo;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RiyoshaFutangakuGengakuViewStateBuilder createBuilderForEdit() {
        return new RiyoshaFutangakuGengakuViewStateBuilder(joho, state, shorigoRirekiNo);
    }

    /**
     * 業務概念「利用者負担額減額」を取得します。
     *
     * @return 利用者負担額減額
     */
    public RiyoshaFutangakuGengaku getRiyoshaFutangakuGengaku() {
        return joho;
    }

    /**
     * EntityDataStateを取得します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return state;
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public int getShorigoRirekiNo() {
        return shorigoRirekiNo;
    }

}
