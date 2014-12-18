/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;

import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikakuHakko;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.HihokenshaShikakuHakkoDiv.発行証タイプ;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「被保険者証資格者証発行」のHandlerクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakkoHandler {

    private final HihokenshaShikakuHakkoDiv div;

    // 仮実装用の受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
    class JyukyushaDaichoYokaigoNinteiJohoModel {

    }

    /**
     * コンストラクタです。
     *
     * @param div 被保険者証資格者証発行Divのエンティティ
     */
    public HihokenshaShikakuHakkoHandler(HihokenshaShikakuHakkoDiv div) {
        this.div = div;
    }

    public void initialize() {
//        1. set有効期限情報()で有効期限、交付日、交付事由をセットする。																								public
        set有効期限情報();
    }

    private void set有効期限情報() {

//            1 交付日にシステム日付を設定する。
        div.getTxtKofuDate().setValue(FlexibleDate.getNowDate());
//            2 モード：発行証Typeが資格者証発行の場合は、有効期限に初期値を設定する。
//            3 モード：発行証Typeを元に、被保険者証発行か資格者証発行かを判定する。
//              発行証によって、交付事由を設定する。
//             3-1 被保険者証発行の場合、コードマスタの被保険者証交付事由(業務コード=DBA、コード種別＝0002)を、
//                 交付事由に設定する(設定時、コードマスタのコードによって昇順にソートして表示する)。
//             3-2 資格者証発行の場合、コードマスタの資格者証交付事由(業務コード=DBA、コード種別＝0004)を、
//                 交付事由に設定する(設定時、コードマスタのコードによって昇順にソートして表示する)。
    }

    public HihokenshaShikakuHakkoModel load(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, boolean is最新発行) {

        // 画面表示情報を格納するModel;
        HihokenshaShikakuHakkoModel model = new HihokenshaShikakuHakkoModel();

//             1. 渡された被保険者番号、識別コード、is最新発行、を元に表示データを取得し、画面にマッピングする。
//             1-1. 保険者を取得する。
//             1-2. 有効期限の初期値を取得する。
//             1-3. 受給者台帳から、要介護状態・認定日・有効期間・申請日を取得する。
//             1-4. 受給者台帳から、区分限度支給額を取得する。
//             1-5. サービス種類支給限度額から、種類支給限度基準額を取得する。
//             1-6. 受給者台帳から、審査会意見を取得する。
//             1-7. 支払方法変更から、給付制限の履歴を3件表示する。
//             1-8. 居宅給付計画事業者作成 及び 居宅給付計画自己作成 から、支援事業者の履歴を3件表示する。
//             1-9. 介護保険施設入退所から、台帳種別 == 被保険者台帳の履歴を3件表示する。
        return model;

    }

    private void set保険者() {
//            1-1. 保険者を取得する。の処理を行う。
//            1 HihokenshaFinder.get直近被保険者資格(HihokenshaNo 被保険者番号)を使用して、直近の被保険者台帳を取得する。
        HihokenshaFinder aa = new HihokenshaFinder();

//            2 市町村情報から保険者を取得する。
//              2-1 被保険者台帳.広住特措置元市町村コードが登録されている場合、広住特措置元市町村コードをキーにして市町村情報を取得する。
//                 市町村情報は、IKoikiKoseiShichosonFinder(仮名)を使用して、保険者コード・保険者名称を取得する。保険者コードはget証記載保険者番号：(仮名)で取得する。保険者名称取得メソッドは未定。
//              2-2 被保険者台帳.広住特措置元市町村コードが登録されていない場合、業務コンフィグから保険者コード、保険者名称を取得する。保険者コードは(DBU：保険者情報_保険者番号)から取得する。保険者名称は(DBU：保険者情報_保険者名称)から取得する。
//            3 画面の保険者に「保険者コード：保険者名称」のフォーマットで設定する。
    }

    /**
     * return 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private JyukyushaDaichoYokaigoNinteiJohoModel load受給者台帳(HihokenshaNo 被保険者番号, boolean is最新発行) {
        JyukyushaDaichoYokaigoNinteiJohoModel ret = new JyukyushaDaichoYokaigoNinteiJohoModel();
//            1 JukyushaDaichoNinteiShinseiKekkaFinder.get受給者台帳認定申請認定結果()を使用して、受給者台帳及び要介護認定申請・要介護認定結果の履歴を取得する。
//            　1-1 is最新発行がtrueの場合、最新データを表示するデータとする。
//            　1-2 is最新発行がfalseの場合、直前データを表示するデータとする。
        return ret;
    }

    /**
     * ※load受給者台帳()で取得したModelを元に処理を行う。<br />
     * arg 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private void set有効期限() {
//             2-1 set有効期限()を使用して有効期限を取得し、画面にセットする。
        if (div.getMode_発行証タイプ() == 発行証タイプ.資格者証) {
            set有効期限();

//            HihokenshaShikakuHakko hihokenshaShikakuHakko = new HihokenshaShikakuHakko();
            div.getTxtYukoKigen().setValue(new RDate(HihokenshaShikakuHakko.get有効期限初期値(RString.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX).toString()));

        }

        //              1-2. 有効期限の初期値を取得する。の処理を行う。
        //                1 dbz.business.HihokenshaShikakuHakko.get有効期限初期値()を使用して、有効期限を取得する。
        //                  引数：申請区分コード ＝ 認定申請情報.認定申請区分(申請時)コード
        //                  引数：申請日 = 認定申請情報.認定申請年月日、
        //                  引数：有効データ認定終了日 ＝ 認定結果情報.認定有効期間終了年月日
        //                2 画面に有効期限をセットする。
    }

    /**
     * ※load受給者台帳()で取得したModelを元に処理を行う。<br />
     * arg 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private void set認定情報() {
//    1-3. 受給者台帳から、要介護状態・認定日・有効期間・申請日を取得する。の処理を行う。
//
//    1 要介護認定結果情報.要介護状態区分コードをキーにして、要介護状態の名称を取得する。要介護状態の名称はEnumクラス(YokaigoJotaiKubun09)から取得する。要介護状態に名称をセットする。
//      ※要介護状態のEnumクラスは制度改正年度ごとに増える予定。名称の取得は将来的にビジネスクラスを使用して取得する予定でが未検討。TODOコメントに注記する。
//    2 要介護認定結果情報.要介護度認定年月日を認定日にセットする。
//    3 要介護認定結果情報.認定有効期間開始年月日を有効期間（開始日）にセットする。
//    4 要介護認定結果情報.認定有効期間終了年月日を有効期間（終了日）にセットする。
//    5 要介護認定申請情報.認定申請年月日を申請日にセットする。
    }

    /**
     * ※load受給者台帳 ()で取得したModelを元に処理を行う。<br />
     * arg : 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private void set区分支給限度額() {
//        1-4. 受給者台帳から、区分限度支給額を取得する。の処理を行う。
//
//        1 受給者台帳.支給限度単位数を支給額に設定する。
//        2 受給者台帳.支給限度有効開始年月日を有効期間（開始日）に設定する。
//        3 受給者台帳.支給限度有効終了年月日を有効期間（終了日）に設定する。
    }

    /**
     * ※load受給者台帳 ()で取得したModelを元に処理を行う。<br />
     * arg : 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private void set種類支給限度基準額() {
//    1-5. サービス種類支給限度額から、種類支給限度基準額を取得する。 の処理を行う。
//    1 ServiceShuruiShikyuGendoGakuFinder.getサービス種類支給限度額()を使用して、サービス種類支給限度額のListを取得する。
//     1-1 業務コンフィグ(DBD：種類支給限度額_取得方法)が0(要介護度をキーにしない)の場合、要介護状態区分＋適用期間(受給者台帳.支給限度有効開始年月日)をキーにして、取得する。
//     1-2 業務コンフィグ(DBD：種類支給限度額_取得方法)が1(要介護度をキーにする)の場合、要介護状態区分をキーにして、取得する。
//    2 サービス種類支給限度額.サービス種類コードを元にサービス種類の名称を取得する。
//       サービス名称は、IKaigoServisManager.get介護サービス(基準日、サービス種類)を使用して取得する。
//       引数の基準日には、受給者台帳.支給限度有効開始年月日を指定する。
//       サービス種類の名称をDataGridにセットする。
//    3 サービス種類支給限度額.支給限度単位数をDataGridにセットする。
    }

    /**
     * ※load受給者台帳 ()で取得したModelを元に処理を行う。<br />
     * arg : 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private void set審査会意見() {
        //        1-6. 受給者台帳から、審査会意見を取得する。の処理を行う。
        //
        //    1 dbz.business.HihokenshaShikakuHakko.create審査会意見()を使用して、審査会意見を取得する。
        //      引数：審査会意見＝認定結果情報.介護認定審査会意見
        //      引数：介護サービス種類＝認定結果情報.介護サービス種類01~30
        //      引数：最大長＝発行証Typeが被保険者証の場合＝198、資格者証の場合＝175。
        //      引数：基準日＝受給者台帳.支給限度有効開始年月日。
        //    2 画面の審査会意見に文言をセットする。

    }

    /**
     * ※load受給者台帳 ()で取得したModelを元に処理を行う。<br />
     * ※load受給者台帳で取得した、要介護認定結果情報.認定有効終了年月日を「履歴最終日」とする。「履歴最終日」より前の履歴データを表示する。 arg
     * : 受給者台帳・要介護認定申請情報・要介護認定結果情報RelateModel
     *
     */
    private void set給付制限(FlexibleDate 履歴最終日) {
        //    1-7. 支払方法変更から、給付制限の履歴を3件表示する。の処理を行う。
        //
        //    1 制限履歴を表示するために、以下の情報を持つ内部クラス(給付制限出力内容)を作成する
        //     RString 制限内容
        //     FlexibleDate 制限期間開始日
        //     FlexibleDate 制限期間終了日
        //     内部クラスを３件保持するインスタンス(給付制限、優先的、優先外)を作成する。
        //
        //     2 HihokenshaFinder.get直近被保険者台帳()を使用して、被保険者台帳を取得する。
        //    3 被保険者台帳.被保険者区分コードにより処理を分岐する。
        //        3-1 被保険者区分コード=2号被保険者の場合
        //         3-1-1 業務コンフィグAを取得する。
        //           被保険者証発行の場合、DBD：支払方法変更_証表示差止_終了分記載区分 を取得する。
        //           資格者証発行の場合  、DBD：支払方法変更_資格者証表示差止_終了分記載区分 を取得する。
        //         3-1-2 業務コンフィグAが1(終了後も記載する)の場合、ShiharaiHohoHenkoFinder.get２号差止履歴()を使用して、履歴を取得する。
        //           履歴を3件、インスタンス給付制限に保持する。その際、※1 履歴出力 の内容で保持する。
        //           履歴を画面にセットする。
        //         3-1-3 業務コンフィグAが0(終了後は記載しない)の場合、ShiharaiHohoHenkoFinder.get２号差止履歴()を使用して、履歴を取得する。
        //           履歴を1件、インスタンス給付制限に保持する。その際、※1 履歴出力 の内容で保持する。
        //           履歴を画面にセットする。
        //
        //           ※1 履歴出力
        //           制限内容＝DBD：支払方法変更_証表示差止_記載文言 または DBD：支払方法変更_資格者証表示差止_記載文言
        //           制限期間開始日＝支払方法変更データ.適用開始年月日。
        //           制限期間開始日＝支払方法変更データ.適用終了年月日。
        //
        //         3-1-4 インスタンス給付制限の内容を画面にセットする。
        //        3-2 被保険者区分コード = 1号被保険者の場合
        //          3-2-1 業務コンフィグBを取得する。
        //            被保険者証発行の場合、DBD：支払方法変更_証表示支払方法_終了分記載区分 を取得する。
        //            資格者証発行の場合  、DBD：支払方法変更_資格者証表示支払方法_終了分記載区分 を取得する。
        //
        //          3-2-2 業務コンフィグBが1(終了後も記載する)の場合、ShiharaiHohoHenkoFinder.get１号償還払化履歴()を使用して、履歴を取得する。
        //            履歴を3件の、インスタンス優先外に保持する。その際、※2 履歴出力 の内容で保持する。
        //
        //          3-2-3 業務コンフィグBが0(終了後は記載しない)の場合、ShiharaiHohoHenkoFinder.get１号償還払化履歴()を使用して、履歴を取得する。
        //            履歴の先頭の1件の支払方法変更データ.終了区分＝""""の場合、インスタンス優先的に保持する。その際、※2 履歴出力 の内容で保持する。
        //
        //            ※2 履歴出力
        //            制限内容＝DBD：支払方法変更_証表示支払方法_記載文言 または DBD：支払方法変更_資格者証表示支払方法_記載文言
        //            制限期間開始日＝支払方法変更データ.適用開始年月日。
        //            制限期間開始日＝支払方法変更データ.適用終了年月日。
        //
        //          3-2-4 業務コンフィグCを取得する。
        //            被保険者証発行の場合、DBD：支払方法変更_証表示減額_終了分記載区分 を取得する。
        //            資格者証発行の場合  、DBD：支払方法変更_資格者証表示減額_終了分記載区分 を取得する。
        //          3-2-5 業務コンフィグCが1(終了後も記載する)の場合、ShiharaiHohoHenkoFinder.get１号減額履歴()を使用して、履歴を取得する。
        //            履歴を3件の、インスタンス優先外に保持する。その際、※3 履歴出力 の内容で保持する。
        //          3-2-6 業務コンフィグCが0(終了後は記載しない)の場合、ShiharaiHohoHenkoFinder.get１号減額履歴()を使用して、履歴を取得する。
        //            履歴の先頭の1件が以下の条件に当てはまらない場合、インスタンス優先的に保持する。その際、※3 履歴出力 の内容で保持する。
        //            <条件 >
        //            ・支払方法変更データ.終了区分<>""
        //            or
        //            ・支払方法変更データ.終了区分＝"" かつ 支払方法変更データ.適用終了年月日＜交付日(システム日付)
        //            ※3履歴出力
        //               制限内容＝DBD：支払方法変更_証表示減額_記載文言 または DBD：支払方法変更_資格者証表示減額_記載文言
        //               制限期間開始日＝支払方法変更データ.適用開始年月日。
        //               制限期間開始日＝支払方法変更データ.適用終了年月日。
        //            3-2-7 インスタンス給付制限にデータをセットする。
        //            インスタンス給付制限に、上限3件までデータをセットする。
        //            ①インスタンス優先的にデータが存在する場合
        //              ①-1 インスタンス優先的のデータをインスタンス給付制限にセットする。
        //              ①-2 インスタンス優先外のデータ「制限期間開始日」の降順でソートし、インスタンス給付制限にセットする。
        //              ①-3 インスタンス給付制限のデータを「制限期間開始日」の降順でソートする。
        //            ②インスタンス優先的にデータが存在しない場合
        //              ②-1 インスタンス優先外のデータ「制限期間開始日」の降順でソートし、インスタンス給付制限にセットする。
        //
        //            3-2-8 インスタンス給付制限の内容を画面にセットする。
    }

    private void set支援事業者(FlexibleDate 履歴最終日) {
        //            1-8. 居宅給付計画事業者作成 及び 居宅給付計画自己作成 から、支援事業者の履歴を3件表示する。の処理を行う。
        //            1 KyotakuKeikakuSakuseiFinderを使用して、被保険者番号をキーに、居宅給付計画届出、居宅給付計画事業者作成 及び 居宅給付計画自己作成 をJoinしたテーブルの履歴を取得する。
        //               居宅給付計画事業者作成が存在する場合、事業者作成として扱う。存在しない場合、自己作成として扱う。
        //
        //            2 履歴を元に、画面に表示する。
        //             2-1 事業者
        //                2-1-1 事業者作成の場合
        //                  2-1-1-2 モード：発行証Typeが被保険者証の場合、dbz.business.HihokenshaShikakuHakko.get被保険者証支援事業者名称()を使用して事業者名称を取得して表示する。
        //                  2-1-1-3 モード：発行証Typeが資格者証の場合、dbz.business.HihokenshaShikakuHakko.get資格者証支援事業者名称()を使用して事業者名称を取得して表示する。
        //                2-1-2 自己作成の場合
        //                   「""自己作成""」を表示する。
        //             2-2 届出日 居宅計画給付届出.届出年月日を表示する
        //             2-3 適用開始日
        //                2-3-1 事業者作成の場合 事業者作成.適用開始年月日を表示する。
        //                2-3-2 自己作成の場合 自己作成.適用開始年月日を表示する。
    }

    /**
     * ※load受給者台帳で取得した、要介護認定結果情報.認定有効終了年月日を「履歴最終日」する。「履歴最終日」より前の履歴データを表示する。
     *
     */
    private void set施設入退所(FlexibleDate 履歴最終日) {
        //        1-9. 介護保険施設入退所から、台帳種別 == 被保険者台帳の履歴を3件表示する。の処理を行う。
        //        1 ShisetsuNyutaishoManager.get個人台帳別施設入退所履歴(ShikibetsuCode 個人識別コード, DaichoType 台帳種別)を使用して、履歴を取得する。
        //        2 入所施設名称を設定する。
        //          2-1 履歴の入所施設種類が介護施設の場合、URのIKaigoJigyoshaDaichoManager(未実装)のgetJigyoshaCurrent(引数＝事業者番号)を使用して施設名を取得する。
        //          2-2 履歴の入所施設種類が他特例施設・適用除外施設の場合、JogaiJushochitokureiTaishoShisetsuManager.get対象施設(ShisetsuType 施設種類, ShisetsuCode 施設コード)を使用して施設情報を取得し、事業者名称を設定する。
    }

    public HihokenshaShikakuHakkoModel get証発行情報() {
        HihokenshaShikakuHakkoModel model = new HihokenshaShikakuHakkoModel();

//            1. 画面に表示されている情報をModelに格納して返す。
        return model;
    }
}
