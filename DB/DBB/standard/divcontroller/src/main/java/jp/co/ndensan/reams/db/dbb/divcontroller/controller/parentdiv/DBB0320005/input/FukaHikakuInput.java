/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;

/**
 * 賦課比較のインプットです。
 */
public class FukaHikakuInput implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private final FukaHikakuMode mode;
    private final List<FukaShokaiKey> fukaShokaiKeys;
    private transient FukaHikakuTargets 比較対象;

    /**
     * 賦課比較Inputを返します。
     *
     * @param mode 賦課比較Mode
     * @param fukaShokaiKeys 画面遷移後にキー情報
     */
    protected FukaHikakuInput(FukaHikakuMode mode, List<FukaShokaiKey> fukaShokaiKeys) {
        this.mode = mode;
        this.fukaShokaiKeys = new ArrayList<>(fukaShokaiKeys);
    }

    /**
     * createFor任意対象比較です。
     *
     * @param x 画面遷移後にキーx
     * @param y 画面遷移後にキーy
     * @return 賦課比較Input
     */
    public static FukaHikakuInput createFor任意対象比較(FukaShokaiKey x, FukaShokaiKey y) {
        return new FukaHikakuInput(FukaHikakuMode.対象指定, Arrays.asList(x, y));
    }

    /**
     * createFor前年度最終との比較です。
     *
     * @param key 画面遷移後にキー
     * @return 賦課比較Input
     */
    public static FukaHikakuInput createFor前年度最終との比較(FukaShokaiKey key) {
        return new FukaHikakuInput(FukaHikakuMode.前年度最終, Arrays.asList(key));
    }

    /**
     * createFor前履歴との比較です。
     *
     * @param x 画面遷移後にキー
     * @param y 画面遷移後にキー
     * @return 賦課比較Input
     */
    public static FukaHikakuInput createFor前履歴との比較(FukaShokaiKey x, FukaShokaiKey y) {
        return new FukaHikakuInput(FukaHikakuMode.前履歴, Arrays.asList(x, y));
    }

    /**
     * Modeを返します。
     *
     * @return Mode
     */
    protected FukaHikakuMode getMode() {
        return this.mode;
    }

    /**
     * 画面遷移後にキーを返します。
     *
     * @param index index
     * @return 画面遷移後にキー
     */
    protected FukaShokaiKey getFukaShokaiKey(int index) {
        if (index <= fukaShokaiKeys.size() - 1) {
            return this.fukaShokaiKeys.get(index);
        }
        return FukaShokaiKey.EMPTY;
    }

    /**
     * 画面遷移後にキーListを返します。
     *
     * @return 画面遷移後にキーList
     */
    protected List<FukaShokaiKey> getFukaShokaiKeys() {
        return new ArrayList<>(this.fukaShokaiKeys);
    }

    /**
     * 比較対象を返します。
     *
     * @return 比較対象
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
