/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ForeignersNameOutput;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.RokenJukyushaNoTaikei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.UnyoKeitaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.GappeiChiikiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.KokuhorenKoikiShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.RokenShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IKoikiKoseiShichoson}の実装です。
 *
 * @author N3327 三浦 凌
 */
public class KoikiKoseiShichoson implements IKoikiKoseiShichoson {

    private final KoseiShichosonMasterModel master;

    /**
     *
     * @param 構成市町村マスタモデル
     */
    public KoikiKoseiShichoson(KoseiShichosonMasterModel 構成市町村マスタモデル) {
        this.master = 構成市町村マスタモデル;
    }

    @Override
    public ShichosonShikibetsuID get市町村識別ID() {
        return master.get市町村識別ID();
    }

    @Override
    public LasdecCode get市町村コード() {
        return master.get市町村コード();
    }

    @Override
    public KokuhorenKoikiShichosonNo get国保連広域内市町村番号() {
        return master.get国保連広域内市町村番号();
    }

    @Override
    public RString get市町村名() {
        return master.get市町村名();
    }

    @Override
    public RString get都道府県名() {
        return master.get都道府県名();
    }

    @Override
    public RString get郡名() {
        return master.get郡名();
    }

    @Override
    public TopPriorityArea get最優先地区() {
        return master.get最優先地区();
    }

    @Override
    public ForeignersNameOutput get外国人氏名表示方法() {
        return master.get外国人氏名表示方法();
    }

    @Override
    public RokenShichosonNo get老人保健市町村番号() {
        return master.get老人保健市町村番号();
    }

    @Override
    public RokenJukyushaNoTaikei get老人保健受給者番号体系() {
        return master.get老人保健受給者番号体系();
    }

    @Override
    public FlexibleDate get移行日() {
        return master.get移行日();
    }

    @Override
    public FlexibleDate get加入日() {
        return master.get加入日();
    }

    @Override
    public FlexibleDate get離脱日() {
        return master.get離脱日();
    }

    @Override
    public GappeiKyuShichosonKubun get合併旧市町村区分() {
        return master.get合併旧市町村区分();
    }

    @Override
    public GappeiKyuShichosonHyoji get合併旧市町村表示有無() {
        return master.get合併旧市町村表示有無();
    }

    @Override
    public GappeiChiikiNo get合併地域番号() {
        return master.get合併地域番号();
    }

    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return master.get運用保険者番号();
    }

    @Override
    public FlexibleDate get運用開始日() {
        return master.get運用開始日();
    }

    @Override
    public FlexibleDate get運用終了日() {
        return master.get運用終了日();
    }

    @Override
    public UnyoKeitaiKubun get運用形態区分() {
        return master.get運用形態区分();
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return master.get証記載保険者番号();
    }

    @Override
    public AtenaJusho get住所() {
        return master.get住所();
    }

    @Override
    public YubinNo get郵便番号() {
        return master.get郵便番号();
    }

    @Override
    public TelNo get電話番号() {
        return master.get電話番号();
    }

    @Override
    public GunNamePrint get群名印字有無() {
        return master.get群名印字有無();
    }

    @Override
    public TodofukenNamePrint get都道府名印字有無() {
        return master.get都道府名印字有無();
    }

    @Override
    public ShichosonNamePrint get市町村名印字有無() {
        return master.get市町村名印字有無();
    }

    @Override
    public KatagakiPrint get方書印字有無() {
        return master.get方書印字有無();
    }

    @Override
    public HowToEditJusho get印字住所編集方法() {
        return master.get印字住所編集方法();
    }
}
