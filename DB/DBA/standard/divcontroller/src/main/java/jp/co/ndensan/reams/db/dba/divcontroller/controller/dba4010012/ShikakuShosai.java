/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba4010012;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010012.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010012.ShikakuShosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 被保険者が資格を取得してから喪失するまでの、詳細な情報を表示するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShosai {

    /**
     * 詳細画面の初期化処理です。
     *
     * @param shikakuShosaiDiv {@link ShikakuShosaiDiv 資格詳細Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShosaiDiv> initialize(ShikakuShosaiDiv shikakuShosaiDiv, KihonJohoDiv kihonDiv) {
        //1, ViewStateから、前画面で設定したModelを取得する。
        //      ViewStateHolder.get(KaigoViewStateKey.被保険者台帳.getKey(), HihokenshaDaichoModel.class)
        //1, ViewStateから取得したModelが持つキー情報を元に、以下のデータを取得する。
        //      被保険者台帳（List）、施設入退所（List）
        //3, それぞれの初期化処理を呼び出して実行してください。
        //      initializedShikakuShosai(div, Modelのキー情報を元に取得した被保険者台帳のListから取得した1件)
        //      initializedJutoku(div, Modelのキー情報を元に取得した被保険者台帳のList)
        //      initializedShikakuKanrenIdo(div, Modelのキー情報を元に取得した被保険者台帳のList)
        //      initializedShikakuKanrenIdo(div, Modelのキー情報を元に取得した施設入退所のList)
        return ResponseDatas.createSettingDataTo(shikakuShosaiDiv);
    }

    //TODO #52997
    //ヘッダー情報の初期表示の制御、値の設定などを行います。
    private void initializedShikakuShosai(ShikakuShosaiDiv div, HihokenshaDaichoModel hihokenshaDaicho) {
        //TODO #52997
        //1, 資格詳細画面のTablePanel上に配置されている、取得日などのヘッダー情報に値を設定する。
        //2, 業務Configの保険者情報を元に、ヘッダー情報の表示非表示を設定する。
        //2-1, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合
        //      「所在保険者」「措置元保険者」「旧保険者」を非表示にする。
        //2-2, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合
        //      「所在保険者」「措置元保険者」を非表示、「旧保険者」を表示する。
        //2-3, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合
        //      「所在保険者」「措置元保険者」を表示、「旧保険者」を非表示にする。
        //2-4, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合
        //      「所在保険者」「措置元保険者」「旧保険者」を表示する。
    }

    //TODO #52997
    //住所地特例情報Tabの初期表示の制御、値の設定などを行います。
    private void initializedJutoku(ShikakuShosaiDiv div, HihokenshaDaichoList hihokenshaDaichoList) {
        //1, hihokenshaDaichoList.to住所地特例List()を実行して、住所地特例情報を抽出する。
        //2, 抽出したデータを住所地特例履歴一覧グリッドに設定する。
        //3, 「追加する」ボタンを非表示にする。
        //4, 「修正」「削除」アイコン、状態列を非表示にする。
        //
        //6, 住所地特例入力明細エリアのDisplayNoneをTrueにする。
        //7, 適用事由DDL(ドロップダウンリスト)に、コード種別:0127(介護資格住特適用)のデータを設定する。
        //8, 解除事由DDLに、コード種別:0128(介護資格住特解除)のデータを設定する。
        //9, 明細エリアの各項目の値をクリアする。
        //
        //10, 「所在保険者DDL」に、所在保険者とその候補になりえる市町村のデータを設定する。
        //11, 「措置元保険者DDL」に、措置元になりえる市町村のデータを設定する。
        //12, 「旧保険者DDL」に、旧保険者になりえる市町村のデータを設定する。
        //
        //13, 業務Configの情報を元に、住所地特例履歴一覧グリッドと、住所地特例適用保険者情報入力エリアの表示・非表示を変更する。
        //13-1, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」「旧保険者」列を非表示にする。
        //      入力エリア: DisplayNoneをtrueにする。
        //13-2, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」列を非表示、「旧保険者」列を表示する。
        //      入力エリア:DisplayNoneをfalse、「所在保険者DDL」「措置元保険者DDL」を非表示、「旧保険者DDL」を表示する。
        //13-3, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」列を表示、「旧保険者」列を非表示にする。
        //      入力エリア:DislplayNoneをfalse、「所在保険者DDL」「措置元保険者DDL」を表示、「旧保険者DDL」を非表示にする。
        //13-4, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」「旧保険者」列を表示する。
        //      入力エリア:DisplayNoneをfaluse、「所在保険者DDL」「措置元保険者DDL」「旧保険者DDL」を表示する。
    }

    //TODO #52997
    //資格関連異動（資格変更）Tabの初期表示の制御、値の設定などを行います。
    private void initializedShikakuKanrenIdo(ShikakuShosaiDiv div, HihokenshaDaichoList hihokenshaDaichoList) {
        //1, hihokenshaDaichoList.to資格関連異動List()を実行して、資格関連異動情報を抽出する。
        //2, 抽出したデータを資格変更履歴一覧グリッドに設定する。
        //3, 「追加する」ボタンを非表示にする。
        //4, 「修正」「削除」アイコン、状態列を非表示にする。
        //
        //6, 資格変更入力明細エリアのDisplayNoneをTrueにする。
        //7, 変更事由DDLに、コード種別:0126(介護資格変更事由（被保険者）)のデータを設定する。
        //8, 明細エリアの各項目の値をクリアする。
        //
        //9, 業務Configの情報を元に、資格変更履歴一覧グリッドと、住所地特例適用保険者情報入力エリアの表示・非表示を変更する。
        //9-1, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」「旧保険者」列を非表示にする。
        //9-2, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」列を非表示、「旧保険者」列を表示する。
        //9-3, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」列を表示、「旧保険者」列を非表示にする。
        //9-4, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合
        //      グリッド:「所在保険者」「措置元保険者」「旧保険者」列を表示する。
        //
    }

    //TODO #52997
    //施設入退所Tabの初期表示の制御、値の設定などを行います。
    //ShisetsuNyutaishoの情報を持つクラスは仮で設定しています。後に依頼する施設入退所で作成したクラスを使用してください。
    private void initializedShikakuKanrenIdo(ShikakuShosaiDiv div) { //, ShisetsuNyutaishoRirekiList shisetsuNyutaishoList) {
        //1, 施設入退所履歴管理共有子Divのモードに、照会を設定する。
        //2, 施設入退所履歴グリッドに、引数から受け取った施設入退所情報を設定する。
        //3, 施設入退所入力明細エリアのDisplayNoneにtrueを設定する。
        //4, 明細エリアの各項目の値をクリアする。
    }
}
