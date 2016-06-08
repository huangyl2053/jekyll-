/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 負担限度額認定申請のViewStateクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 *
 */
public class FutanGendogakuNinteiViewState implements Serializable {

    private FutanGendogakuNintei joho;
    private EntityDataState state;
    private int shorigoRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param joho 業務概念「介護保険負担限度額認定」
     * @param state EntityDataState
     * @param shorigoRirekiNo 履歴番号
     */
    public FutanGendogakuNinteiViewState(FutanGendogakuNintei joho, EntityDataState state, int shorigoRirekiNo) {
        this.joho = joho;
        this.state = state;
        this.shorigoRirekiNo = shorigoRirekiNo;
    }

    /**
     * 業務概念「介護保険負担限度額認定」を取得します。
     *
     * @return 介護保険負担限度額認定
     */
    public FutanGendogakuNintei getFutanGendogakuNintei() {
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

    /**
     * 業務概念「介護保険負担限度額認定」を設定します。
     *
     * @param joho 介護保険負担限度額認定
     */
    public void setFutanGendogakuNintei(FutanGendogakuNintei joho) {
        this.joho = joho;
    }

    /**
     * EntityDataStateを設定します。
     *
     * @param state EntityDataState
     */
    public void setState(EntityDataState state) {
        this.state = state;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param shorigoRirekiNo 履歴番号
     */
    public void setShorigoRirekiNo(int shorigoRirekiNo) {
        this.shorigoRirekiNo = shorigoRirekiNo;
    }
}
