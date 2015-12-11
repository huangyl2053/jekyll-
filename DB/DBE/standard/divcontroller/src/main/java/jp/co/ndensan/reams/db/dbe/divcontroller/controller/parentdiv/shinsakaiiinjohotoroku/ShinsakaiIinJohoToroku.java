package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.shinsakaiiinjohotoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranEntity;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * ShinsakaiIinJohoToroku のクラスファイル 介護認定審査会委員情報を登録・修正・削除する機能、 削除の場合は論理削除を行う。
 */
public class ShinsakaiIinJohoToroku {

    private static final RString 新規モード = new RString("新規");
    private static final RString 更新モード = new RString("更新");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static RString モード;

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     */
    public ResponseData onLoad(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();

        div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().init();
        div.getShinsakaiIinJoho().getDdlShikakuCode().setDataSource(service.get資格コードList());
        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setDataSource(service.get審査員郵送区分List());

        createHandOf(div).load();
        response.data = div;
        return response;
    }

    /**
     * 「検索する」ボタンを押下、審査会委員情報を取得する。
     *
     * * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnKensaku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();

        List<ShinsakaiIinJoho> list = service.get審査会委員一覧(div.getKensakuJoken().getRadHyojiJoken().getSelectedKey());
        div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().setDataSource(createHandOf(div).setShinsaInJohoIchiranDiv(list));
        response.data = div;
        return response;
    }

    /**
     * 審査会委員一覧Gridの行クリックの処理です。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_shinsaInJohoIchiranGyo(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!(新規モード.equals(モード) || 更新モード.equals(モード))) {
            ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();
            createHandOf(div).setDivShinsakaiIinJoho();
            createHandOf(div).setDivRenrakusakiKinyuKikan();
//            TODO ２.　所属機関一覧検索
            List<ShozokuKikanIchiranEntity> list = service.get所属機関一覧(
                    new ShinsakaiIinJohoMapperParameter(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode()));
            div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().setDataSource(createHandOf(div).setShozokuKikanIchiranDiv(list));
        }
        response.data = div;
        return response;
    }

    /**
     * 廃止フラグを選択変更処理です。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    // TODO RAMLファイルと設計書不一致
    public ResponseData onChange_haishiFlag(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 審査会委員一覧Gridの行ダブルクリック処理です。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onDoubleClick_shinsaInJohoIchiranGyo(ShinsakaiIinJohoTorokuDiv div) {
        return onClick_btnModifyShinsaInJohoIchiran(div);
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタン処理です。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnModifyShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (新規モード.equals(モード) || 更新モード.equals(モード)) {
            boolean hasChanged合議体詳細情報 = createHandOf(div).hasChanged合議体詳細情報();
            if (hasChanged合議体詳細情報) {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
                }
            }
        }
        モード = 更新モード;
//      TODO ２.　所属機関一覧検索
        createHandOf(div).set修正部品状態();
        response.data = div;
        return response;
    }

    /**
     * 「審査会委員一覧の削除」アイコンをクリック処理です。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnDeleteShinsaInJohoIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (状態_追加.equals(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getStatus())) {
            div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource().
                    remove(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem());
        } else {
            div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().setStatus(状態_削除);
        }
        response.data = div;
        return response;
    }

    /**
     * 「審査会委員を追加する」ボタンを押下します。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnShinsakaiIinAdd(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        モード = 新規モード;
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.set追加部品状態();
        handler.clear審査会委員詳細情報();
        handler.clear連絡先金融機関();
        div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource().add(new dgShinsaInJohoIchiran_Row());
        response.data = div;
        return response;
    }

    /**
     * 「補助入力ボタン」ボタン押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnShinsakaiChikuCode(ShinsakaiIinJohoTorokuDiv div) {
        return onClick_shinsaInJohoIchiranGyo(div);
    }

    /**
     * 「所属機関を追加する」ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnShozokuKikanAdd(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().getDataSource().add(new dgShozokuKikanIchiran_Row());
        response.data = div;
        return response;
    }

    /**
     * 所属機関一覧Gridの削除ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnDeleteShozokuKikanIchiran(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzQuestionMessages.削除の確認.getMessage()).respond();
        }
        div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().getDataSource().
                remove(div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().getClickedItem());
        response.data = div;
        return response;
    }

    /**
     * 認定調査委託先コード補助入力ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnNiteiChosaItakusakiGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 主治医医療機関コード補助入力ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnShujiiIryoKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * その他機関コード補助入力ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnSonotaKikanGuide(ShinsakaiIinJohoTorokuDiv div) {
        // TODO ダイアログを表示する.
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 「入力内容を更新する」ボタンを押下する。
     *
     * @param div
     * @return レスポンス
     */
    public ResponseData onClick_btnToroku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();

        if (!更新モード.equals(モード)) {
            boolean is重複コード = createHandOf(div).is重複コード();
            if (is重複コード) {
                return ResponseData.of(div).addMessage(UrErrorMessages.既に登録済.getMessage()).respond();
            } else {
                ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();
                int count = service.get審査会委員カウント(new ShinsakaiIinJohoMapperParameter(div.getShinsakaiIinJoho().getTxtShinsainCode().getValue()));
                if (0 < count) {
                    return ResponseData.of(div).addMessage(UrErrorMessages.既に登録済.getMessage()).respond();
                }
            }
            if (div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().getValue().isBefore(div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().getValue())) {
                return ResponseData.of(div).addMessage(UrErrorMessages.終了日が開始日以前.getMessage()).respond();
            }
//        UzT0007CodeEntity 開催地区コード
//                = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().getCode());
//        if (開催地区コード == null || 開催地区コード.isEmpty()) {
//            return ResponseData.of(div).addMessage(UrErrorMessages.コードマスタなし.getMessage()).respond();
//        }
        }
        set審査会委員詳細To委員一覧(div);
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
//      TODO 所属機関一覧データは内部記録する
        handler.shinsakaiIinJohoDiv_init();
        handler.shozokuKikanIchiranDiv_init();
        handler.renrakusakiKinyuKikanDiv_init();
        response.data = div;
        return response;
    }

    /**
     * 「入力内容を取消する」ボタン押下。
     *
     * @param div
     * @return レスポンス
     */
    public ResponseData onClick_btnDelete(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
// TODO 合議体情報編集エリア入力した値はクリア
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        handler.clear審査会委員詳細情報();
        handler.shinsakaiIinJohoDiv_init();
        handler.shozokuKikanIchiranDiv_init();
        handler.renrakusakiKinyuKikanDiv_init();

        response.data = div;
        return response;
    }

    /**
     * 「口座情報を登録する」ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnKozaJohoToroku(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        // TODO ダイアログを表示する.
        // 口座情報照会ダイアログを表示する
        response.data = div;
        return response;
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div ShinsakaiIinJohoTorokuDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnSave(ShinsakaiIinJohoTorokuDiv div) {
        ResponseData<ShinsakaiIinJohoTorokuDiv> response = new ResponseData<>();
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
//       TODO 基盤側から共通部品を利用して、前排他制御を行う。
//       div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource().get(0).getShinsainCode().toString();
//       RealInitialLocker.lock(new LockingKey(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource().get(0).getShinsainCode()));
//       TODO 基盤側から排他解除共通部品を利用して、前排他制御の解除を行う。
//       if(他DBにて使用されている場合にエラーメッセージを表示する。){
//       return ResponseData.of(div).addMessage(DbzErrorMessages.更新処理を中止.getMessage()).respond();
//       TODO 業務概念について
        List<dgShinsaInJohoIchiran_Row> list = div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource();
        ShinsakaiIinJohoManager service = ShinsakaiIinJohoManager.createInstance();
        ShinsakaiIinJohoTorokuHandler handler = createHandOf(div);
        for (dgShinsaInJohoIchiran_Row row : list) {
            if (new RString("追加").equals(row.getStatus())) {

            } else if (new RString("修正").equals(row.getStatus())) {

            } else if (new RString("削除").equals(row.getStatus())) {

            } else {
                continue;
            }
        }
        service.get審査会委員一覧(div.getKensakuJoken().getRadHyojiJoken().getSelectedKey());
        onLoad(div);
//      TODO 内部記録した所属機関一覧データをクリア
        response.data = div;
        return response;
    }

    private List<dgShinsaInJohoIchiran_Row> set審査会委員詳細To委員一覧(ShinsakaiIinJohoTorokuDiv div) {
        List<dgShinsaInJohoIchiran_Row> list = div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource();
        int count = div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getGridSetting().selectedRowCount();
        dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
        row.setShinsainCode(div.getShinsakaiIinJoho().getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getShinsakaiIinJoho().getTxtShimei().getValue());
        row.setKanaShimei(div.getShinsakaiIinJoho().getTxtKanaShimei().getValue());
        row.setSeibetsu(div.getShinsakaiIinJoho().getRadSeibetsu().getSelectedValue());
        row.getBarthYMD().setValue(div.getShinsakaiIinJoho().getTxtBirthYMD().getValue().toRDate());
        row.setShikakuCode(div.getShinsakaiIinJoho().getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getShinsakaiIinJoho().getTxtBiko().getValue());
        row.setJokyo(div.getTxtHaishiFlag().getValue());
//        row.setYubinNo(div.getRenrakusakiKinyuKikan().getTxtYubinNo().getValue().value());
//        row.setYusoKubun(div.getRenrakusakiKinyuKikan().getDdlYusoKubun().getSelectedValue());
//        row.setJusho(div.getRenrakusakiKinyuKikan().getTxtJusho().getDomain().value());
//        row.getHaishiYMD().setValue(div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().getValue());
//        row.setTelNo(div.getRenrakusakiKinyuKikan().getTxtTelNo1().getDomain().value());
//        row.setFaxNo(div.getRenrakusakiKinyuKikan().getTxtFaxNo().getDomain().value());
        if (新規モード.equals(モード)) {
            row.setStatus(状態_追加);
            list.add(row);
        } else if (更新モード.equals(モード)) {
            row.setStatus(状態_修正);
            list.set(count, row);
        }
        return list;
    }

    private ShinsakaiIinJohoTorokuHandler createHandOf(ShinsakaiIinJohoTorokuDiv div) {
        return new ShinsakaiIinJohoTorokuHandler(div);
    }
}
