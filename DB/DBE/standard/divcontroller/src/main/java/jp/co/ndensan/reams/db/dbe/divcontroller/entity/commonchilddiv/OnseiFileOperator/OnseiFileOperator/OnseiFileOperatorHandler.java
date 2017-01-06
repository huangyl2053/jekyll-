/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 音声情報操作用共有子Divのハンドラクラスです。
 */
public class OnseiFileOperatorHandler {

    private final OnseiFileOperatorDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 音声情報共有子Divパネル
     */
    public OnseiFileOperatorHandler(OnseiFileOperatorDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divを 審査会音声情報 を基に初期化します。
     *
     * @param 審査会音声情報 審査会音声情報
     * @param 追加日時 追加日時
     */
    public void initialize(ShinsakaiOnseiJoho2 審査会音声情報, RDateTime 追加日時) {
        if (審査会音声情報 == null) {
            clearValue();
            return;
        }
        if (審査会音声情報.isEntitiyDeleted()) {
            clearValue();
            set削除状態();
            return;
        }
        div.setBizData(審査会音声情報.get介護認定審査会開催番号());
        div.getTxtNo().setValue(new Decimal(審査会音声情報.get連番()));
        div.getTxtInsDate().setValue(get日時文字列(追加日時));
        set存在状態();

    }

    /**
     * 共有子Divを 審査会音声情報 を基に初期化します。
     *
     * @param 審査会音声情報 審査会音声情報
     */
    public void initialize(ShinsakaiOnseiJoho2 審査会音声情報) {
        initialize(審査会音声情報, 審査会音声情報.getInsertTimestamp());
    }

    /**
     * 内容をクリアします。
     */
    public void clearValue() {
        div.setBizData(null);
        div.getTxtNo().clearValue();
        div.getTxtInsDate().clearValue();
        div.getBtnDelete().setDisplayNone(true);
        div.getBtnDownload().setDisplayNone(true);
        div.getOnseiFileDeleted().setDisplayNone(true);
    }

    /**
     * ボタンなどの状態を、音声情報が存在する状態にします。
     */
    public void set存在状態() {
        div.getBtnDelete().setDisplayNone(false);
        div.getBtnDownload().setDisplayNone(false);
        div.getOnseiFileDeleted().setDisplayNone(true);
    }

    /**
     * ボタンなどの状態を、音声情報が削除された状態にします。
     */
    public void set削除状態() {
        div.getBtnDelete().setDisplayNone(true);
        div.getBtnDownload().setDisplayNone(true);
        div.getOnseiFileDeleted().setDisplayNone(false);
    }

    /**
     * 共有子Divの持つ音声情報の審査会管理番号を返します。
     *
     * @return 審査会管理番号
     */
    public RString get審査会管理番号() {
        return div.getBizData();
    }

    /**
     * 共有子Divの持つ音声情報の連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        if (div.getTxtNo().getValue() == null) {
            return 0;
        }
        return div.getTxtNo().getValue().intValue();
    }

    private RString get日時文字列(RDateTime 日時) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(日時.getDate().wareki().toDateString());
        builder.append(RString.HALF_SPACE);
        builder.append(日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        return builder.toRString();
    }

}
