/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;

/**
 * 被保険者証B4版のBuilderを生成するファクトリクラスです。
 *
 * @author n8178 城間篤人
 */
public final class HihokenshashoBuilderFactory {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private HihokenshashoBuilderFactory() {
    }

    /**
     * 単票発行時の被保険者証B4版Builderを生成します。印字位置は、引数の被保険者証Modelが持つ印字位置を元に決定します。
     *
     * @return 単票発行時の被保険者証B4版
     */
    public static HihokenshashoB4Builder createInstanceForB4(HihokenshashoModel hihokenshashoModel) {
        //TODO
        //1, 生成したBuilderを返却する。印字位置は、hihokenshaModelが持つ印字位置によって決定される。
        return null;
    }

    /**
     * 被保険者証A4版Builderを生成します。
     *
     * @return 単票発行時の被保険者証A4版
     */
    public static HihokenshashoB4Builder createInstanceForA4(HihokenshashoModel hihokenshashoModel) {
        //TODO
        //1, 生成したBuilderを返却する。
        return null;
    }

    //TODO n8178 城間篤人 被保険者証B4版Builderについて、複数人分の被保険者証を一括発行する際の、上下ともに印字する場合のcreateメソッドが、バッチ処理などで必要になる。 2015年2月末
}
