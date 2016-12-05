/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.ShujiiMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001.dgShujiiIchiran_Row;
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 主治医マスタ画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0250-010 suguangjun
 */
public class ShujiiMasterValidationHandler {

    private final ShujiiMasterDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public ShujiiMasterValidationHandler(ShujiiMasterDiv div) {
        this.div = div;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     */
    public void validateForOutputCsv() {
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            throw new ApplicationException(InfoMesssages.該当データなし.getMessage());
        }
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                throw new ApplicationException(InfoMesssages.編集後更新指示.getMessage());
            }
        }
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @param count 主治医情報件数
     */
    public void validateForKakutei(RString 状態, int count) {
        if ((状態_追加.equals(状態) || 状態_修正.equals(状態)) && (状態_修正.equals(状態) && !isUpdate())) {
            throw new ApplicationException(InfoMesssages.編集なしで更新不可.getMessage());
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShichoson().getValue())
                    && RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShichosonmei().getValue())) {
                throw new ApplicationException(InfoMesssages.市町村コードが存在しない.getMessage());
            }
            if (!RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShujiiIryoKikanCode().getValue())
                    && RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShujiiIryoKikanMei().getValue())) {
                throw new ApplicationException(InfoMesssages.主治医医療機関コードが存在しない.getMessage());
            }
            if (0 < count) {
                throw new ApplicationException(InfoMesssages.主治医コードは既に登録済.getMessage());
            }
        }
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     */
    public void validateForUpdate() {

        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            throw new ApplicationException(InfoMesssages.編集なしで更新不可.getMessage());
        }
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param ninteiShinseiJohoCount 要介護認定申請情報件数
     * @param ikenshoIraiJohoCount 主治医意見書作成依頼情報件数
     */
    public void validateForUpdate(int ninteiShinseiJohoCount, int ikenshoIraiJohoCount) {
        if (0 < ninteiShinseiJohoCount) {
            throw new ApplicationException(InfoMesssages.排他_他のユーザが更新済で更新処理を中止.getMessage());
        }
        if (0 < ikenshoIraiJohoCount) {
            throw new ApplicationException(InfoMesssages.排他_他のユーザが更新済で更新処理を中止.getMessage());
        }
    }

    /**
     * 検索ボタンを押下するとき、検索結果がゼロ件の場合チェックを行う。
     *
     */
    public void validateBtnReSearchNoResult() {
        throw new ApplicationException(InfoMesssages.該当データなし.getMessage());
    }

    /**
     * 主治医情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        ShujiiMasterHandler handler = new ShujiiMasterHandler(div);
        return !handler.getInputDiv().equals(div.getShujiiJohoInput().getHiddenInputDiv());
    }

    private enum InfoMesssages implements IMessageGettable {

        該当データなし(1, "該当データが存在しません。"),
        編集後更新指示(2, "編集されています。更新処理を行ってください。"),
        地区コードが存在しない(3, "地区コードに該当するデータが存在しません。"),
        市町村コードが存在しない(4, "市町村コードに該当するデータが存在しません。"),
        主治医医療機関コードが存在しない(5, "主治医医療機関コードに該当するデータが存在しません。"),
        編集なしで更新不可(6, "編集されていないため、更新できません。"),
        主治医コードは既に登録済(7, "主治医コードは既に登録されているため使用できません。"),
        排他_他のユーザが更新済で更新処理を中止(8, "他の端末で対象のデータが変更されているため、更新処理を中止します。");

        private final int no;
        private final RString message;

        private InfoMesssages(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new InformationMessage(toCode("I", no), message.toString());
        }
    }
}
