/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者台帳情報の取得、保存、削除を提供するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoFinder implements IHihokenshaDaichoFinder {

    //private final HihokenshaDaichoDac dac;
    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoFinder() {
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
    @Override
    public HihokenshaDaichoModel find被保険者台帳(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号, YMDHMS 処理日時) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号・処理日時を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。
        //2, EntityをHihokenshaDaichoModelに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HihokenshaDaichoList find被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //2, EntityのListをHihokenshaDaichoListに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HihokenshaDaichoList find被保険者台帳List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・識別コードを指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //2, 取得したEntityListから、識別コードに紐付く最新のEntityを取得します。
        //3, 最新のEntityが持つ被保険者番号を取得します。
        //4, 取得した被保険者番号を元にもう一度検索を行います。
        //      (find被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号)を呼び出す。)
        //5, 検索結果をreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HihokenshaDaichoList find被保険者台帳List(LasdecCode 市町村コード, KaigoHihokenshaNo 被保険者番号, FlexibleDate 資格取得日) {
        //TODO #52997
        //1, Dacクラスの、市町村コード・被保険者番号・資格取得日を指定するメソッドを呼び出し、DbT1001HihokenshaDaichoEntityのListを取得します。
        //   Dacに当該メソッドが存在しない場合は追加してください。Dacが返るListは必ず、取得日の降順になるようにしてください。
        //2, EntityのListをHihokenshaDaichoListに変換してreturnします。
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
