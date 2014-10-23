/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence;

import jp.co.ndensan.reams.db.dba.model.ShikakuShutokuKanrenJohoModel;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格取得時に、1トランザクションで複数のテーブルを更新するためのDacです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuKanrenJohoDac {

    private SqlSession session;

    /**
     * 資格取得関連情報Modelが持つデータを、DBに登録します。
     *
     * @param model 資格取得関連情報Model
     * @return 登録した件数
     */
    @Transaction
    public int insertOrUpdateOrDelete(ShikakuShutokuKanrenJohoModel model) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        int saveNum = 0;

        //TODO #52997
        //モデルの各要素をDBに登録する処理を実装してください。
        //
        //1, 被保険者台帳ModelListの更新処理を行う。
        //   被保険者台帳ModelListの要素に対して、以下の処理をfor文でくりかえし実行する。
        //1-1, 被保険者台帳ModelのgetStateを呼び、その結果で処理を分岐する。
        //      getState == Added：被保険者台帳Dacのinsertを実行する
        //      getState == Modified：被保険者台帳Dacのupdateを実行する
        //      getState == Deleted：被保険者台帳Dacのdeleteを実行する
        //1-2, 実行した結果の戻り値を、saveNumに足す。
        //2, 医療保険加入状況ModelListの更新処理を行う。
        //   医療保険加入状況ModelListの要素に対して、以下の処理をfor文でくりかえし実行する。
        //2-1, 医療保険加入状況ModelのgetStateを呼び、その結果で処理を分岐する。
        //      getState == Added：医療保険加入状況Dacのinsertを実行する
        //      getState == Modified：医療保険加入状況Dacのupdateを実行する
        //      getState == Deleted：医療保険加入状況Dacのdeleteを実行する
        //2-2, 実行した結果の戻り値を、saveNumに足す。
        //3, 生活保護ModelListの更新処理を行う。
        //   生活保護ModelListの要素に対して、以下の処理をfor文でくりかえし実行する。
        //3-1, 生活保護ModelのgetStateを呼び、その結果で処理を分岐する。
        //      getState == Added：生活保護Dacのinsertを実行する
        //      getState == Modified：生活保護Dacのupdateを実行する
        //      getState == Deleted：生活保護Dacのdeleteを実行する
        //3-2, 実行した結果の戻り値を、saveNumに足す。
        //4, 老齢福祉ModelListの更新処理を行う。
        //   老齢福祉ModelListの要素に対して、以下の処理をfor文でくりかえし実行する。
        //4-1, 老齢福祉ModelのgetStateを呼び、その結果で処理を分岐する。
        //      getState == Added：老齢福祉Dacのinsertを実行する
        //      getState == Modified：老齢福祉Dacのupdateを実行する
        //      getState == Deleted：老齢福祉Dacのdeleteを実行する
        //4-2, 実行した結果の戻り値を、saveNumに足す。
        //5, 施設入退所ModelListの更新処理を行う。
        //   施設入退所ModelListの要素に対して、以下の処理をfor文でくりかえし実行する。
        //5-1, 施設入退所ModelのgetStateを呼び、その結果で処理を分岐する。
        //      getState == Added：施設入退所Dacのinsertを実行する
        //      getState == Modified：施設入退所Dacのupdateを実行する
        //      getState == Deleted：施設入退所Dacのdeleteを実行する
        //5-2, 実行した結果の戻り値を、saveNumに足す。
        //6, saveNumを戻り値として返す。saveNumは更新件数となる。
        return saveNum;
    }

}
