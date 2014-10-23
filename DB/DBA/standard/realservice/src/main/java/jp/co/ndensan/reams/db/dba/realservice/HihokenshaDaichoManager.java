/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.business.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dba.business.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳情報の取得、保存、削除を提供するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoManager {

    //private final HihokenshaDaichoDac dac;
    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoManager() {
        //TODO #52997
        //メンバのHihokenshaDaichoDacのインスタンスを、InstanceProviderを使用して作成します。
        //
        //実装イメージ（Dacクラスは、自動生成されたものに置き換えてください。
        //dac = InstanceProvider.create(HihokenshaDaichoDac.class)
    }

    //TODO #52997
    //引数からDacを受け取る、テスト用コンストラクタを用意してください。
    //アクセス修飾子は指定無し(package private)にしてください。
    //HihoHihokenshaDaichoManager(HihokenshaDaichoDac dac){
    //  this.dac = dac;
    //}
    /**
     * 被保険者台帳のキー項目を指定して、該当する被保険者台帳を1件取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return 被保険者台帳
     */
    public HihokenshaDaicho get被保険者台帳(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号, YMDHMS 処理日時) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号・処理日時を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。
        //2, EntityのをHihokenshaDaichoに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 被保険者番号と市町村コードを指定して、特定の被保険者の台帳情報をListで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 被保険者台帳List
     */
    public HihokenshaDaichoList get被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //2, EntityのListをHihokenshaDaichoListに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 識別コードと市町村コードを指定して、特定の被保険者の台帳情報をListで取得します。<br/>
     * 被保険者番号が取得できなかった場合などに利用します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 被保険者番号
     * @return 被保険者台帳List
     */
    public HihokenshaDaichoList get被保険者台帳List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・識別コードを指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //2, 取得したEntityListから、識別コードに紐付く最新のEntityを取得します。
        //3, 最新のEntityが持つ被保険者番号を取得します。
        //4, 取得した被保険者番号を元にもう一度検索を行います。
        //      (get被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号)を呼び出す。)
        //5, 検索結果をreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 市町村コード・被保険者番号・資格取得日を指定して、ある資格取得期間中の被保険者台帳情報をListで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 資格取得日 資格取得日
     * @return ある資格取得期間中の被保険者台帳List
     */
    public HihokenshaDaichoList get被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号, FlexibleDate 資格取得日) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号・資格取得日を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //2, EntityのListをHihokenshaDaichoListに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 引数から被保険者台帳情報を受け取り、DBに保存します。
     *
     * @param 被保険者台帳Model 被保険者台帳Model
     * @return 被保険者台帳
     */
    public boolean save(HihokenshaDaichoModel 被保険者台帳Model) {
        //TODO #52997
        //被保険者台帳Modelが持つgetState()の結果を元に、
        //insert or update or deleteのどちらを実行するか判定します。
        boolean result = false;
        EntityDataState state = 被保険者台帳Model.getState();
        switch (state) {
            case Added:
                //TODO #52997 被保険者台帳Dacのinsertを呼び出します。
                break;
            case Modified:
                //TODO #52997 被保険者台帳Dacのupdateを呼び出します。
                break;
            case Deleted:
                //TODO #52997 被保険者台帳Dacのdeleteを呼び出します。
                break;
            default:
                break;
        }

        return result;
    }

}
