/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;

/**
 * 賦課比較のインプットです。
 */
public class FukaHikakuInput implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private final FukaHikakuMode mode;
    private final List<FukaShokaiKey> fukaShokaiKeys;
    transient private FukaHikakuTargets 比較対象;

    protected FukaHikakuInput(FukaHikakuMode mode, List<FukaShokaiKey> fukaShokaiKeys) {
        this.mode = mode;
        this.fukaShokaiKeys = new ArrayList<>(fukaShokaiKeys);
    }

    public static FukaHikakuInput createFor任意対象比較(FukaShokaiKey x, FukaShokaiKey y) {
        return new FukaHikakuInput(FukaHikakuMode.対象指定, Arrays.asList(x, y));
    }

    public static FukaHikakuInput createFor前年度最終との比較(FukaShokaiKey key) {
        return new FukaHikakuInput(FukaHikakuMode.前年度最終, Arrays.asList(key));
    }

    public static FukaHikakuInput createFor前履歴との比較(FukaShokaiKey x, FukaShokaiKey y) {
        return new FukaHikakuInput(FukaHikakuMode.前履歴, Arrays.asList(x, y));
    }

    /**
     *
     * @return
     */
    protected FukaHikakuMode getMode() {
        return this.mode;
    }

    /**
     *
     * @param index
     * @return
     */
    protected FukaShokaiKey getFukaShokaiKey(int index) {
        return this.fukaShokaiKeys.get(index);
    }

    /**
     *
     * @return
     */
    protected List<FukaShokaiKey> getFukaShokaiKeys() {
        return new ArrayList<>(this.fukaShokaiKeys);
    }

    /**
     *
     * @return
     */
    public FukaHikakuTargets get比較対象() {
        if (this.比較対象 == null) {
            this.比較対象 = new FukaHikakuTargets(this);
        }
        return this.比較対象;
    }

    /**
     * 前画面へ戻る時の戻り先を判定します。
     *
     * @return {true 賦課照会画面} {false 世帯員所得画面}
     */
    public boolean isBackTo賦課照会画面() {
        return this.mode == FukaHikakuMode.前年度最終
                || this.mode == FukaHikakuMode.前履歴;
    }
}
