/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteichosaikkatsuinput;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査時間一括設定のダイアログパラメータクラスです。
 */
public class NinteiChosaIkkatsuInputModel implements Serializable {

    private FlexibleDate 設定年月;
    private FlexibleDate 認定調査予定年月日;
    private RString 曜日;
    private Code 認定調査時間枠;
    private RString 認定調査予定開始時間;
    private RString 認定調査予定終了時間;
    private boolean 既に設定済みの場合上書きするフラグ;
    private List<NinteiChosaIkkatsuInputModel> modelList;

    /**
     * 設定年月を返します。
     *
     * @return 設定年月
     */
    public FlexibleDate get設定年月() {
        return 設定年月;
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return 認定調査予定年月日;
    }

    /**
     * 曜日を返します。
     *
     * @return 曜日
     */
    public RString get曜日() {
        return 曜日;
    }

    /**
     * 認定調査時間枠を返します。
     *
     * @return 認定調査時間枠
     */
    public Code get認定調査時間枠() {
        return 認定調査時間枠;
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予定開始時間
     */
    public RString get認定調査予定開始時間() {
        return 認定調査予定開始時間;
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予定終了時間
     */
    public RString get認定調査予定終了時間() {
        return 認定調査予定終了時間;
    }

    /**
     * 既に設定済みの場合上書きするフラグを返します。
     *
     * @return 既に設定済みの場合上書きするフラグ
     */
    public boolean is既に設定済みの場合上書きするフラグ() {
        return 既に設定済みの場合上書きするフラグ;
    }

    /**
     * modelListを返します。
     *
     * @return modelList
     */
    public List<NinteiChosaIkkatsuInputModel> getModelList() {
        return modelList;
    }

    /**
     * 設定年月を設定します。
     *
     * @param 設定年月 FlexibleDate
     */
    public void set設定年月(FlexibleDate 設定年月) {
        this.設定年月 = 設定年月;
    }

    /**
     * 認定調査予定年月日を設定します。
     *
     * @param 認定調査予定年月日 FlexibleDate
     */
    public void set認定調査予定年月日(FlexibleDate 認定調査予定年月日) {
        this.認定調査予定年月日 = 認定調査予定年月日;
    }

    /**
     * 曜日を設定します。
     *
     * @param 曜日 RString
     */
    public void set曜日(RString 曜日) {
        this.曜日 = 曜日;
    }

    /**
     * 認定調査時間枠を設定します。
     *
     * @param 認定調査時間枠 Code
     */
    public void set認定調査時間枠(Code 認定調査時間枠) {
        this.認定調査時間枠 = 認定調査時間枠;
    }

    /**
     * 認定調査予定開始時間を設定します。
     *
     * @param 認定調査予定開始時間 RString
     */
    public void set認定調査予定開始時間(RString 認定調査予定開始時間) {
        this.認定調査予定開始時間 = 認定調査予定開始時間;
    }

    /**
     * 認定調査予定終了時間を設定します。
     *
     * @param 認定調査予定終了時間 RString
     */
    public void set認定調査予定終了時間(RString 認定調査予定終了時間) {
        this.認定調査予定終了時間 = 認定調査予定終了時間;
    }

    /**
     * 既に設定済みの場合上書きするフラグを設定します。
     *
     * @param 既に設定済みの場合上書きするフラグ boolean
     */
    public void set既に設定済みの場合上書きするフラグ(boolean 既に設定済みの場合上書きするフラグ) {
        this.既に設定済みの場合上書きするフラグ = 既に設定済みの場合上書きするフラグ;
    }

    /**
     * modelListを設定します。
     *
     * @param modelList List<NinteiChosaIkkatsuInputModel>
     */
    public void setModelList(List<NinteiChosaIkkatsuInputModel> modelList) {
        this.modelList = modelList;
    }

}
