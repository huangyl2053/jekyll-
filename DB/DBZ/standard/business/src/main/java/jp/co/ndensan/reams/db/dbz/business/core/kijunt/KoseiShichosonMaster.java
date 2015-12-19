/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kijunt;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kijuntsu.KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域合併市町村情報の取得します
 *
 */
public class KoseiShichosonMaster implements IKoseiShichosonMaster {

    private final KoseiShichosonMasterEntity entity;

    public KoseiShichosonMaster(KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    @Override
    public RString get市町村識別ID() {
        return entity.getShichosonShokibetsuID();
    }

    @Override
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    @Override
    public RString get国保連広域内市町村番号() {
        return entity.getKokuhorenKoikiShichosonNo();
    }

    @Override
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    @Override
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    @Override
    public RString get郡名称() {
        return entity.getGunMeisho();
    }

    @Override
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    @Override
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    @Override
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    @Override
    public RString get最優先地区コード() {
        return entity.getYusenChikuCode();
    }

    @Override
    public RString get帳票用都道府県名称表示有無() {
        return entity.getTyohyoTodoufukenHyojiUmu();
    }

    @Override
    public RString get帳票用郡名称表示有無() {
        return entity.getTyohyoGunHyojiUmu();
    }

    @Override
    public RString get帳票用市町村名称表示有無() {
        return entity.getTyohyoShichosonHyojiUmu();
    }

    @Override
    public RString get帳票用住所編集方法() {
        return entity.getTyohyoJushoHenshuHouhou();
    }

    @Override
    public RString get帳票用方書表示有無() {
        return entity.getTyohyoKatagakiHyojiUmu();
    }

    @Override
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    @Override
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    @Override
    public RString get特徴分配集約() {
        return entity.getTokuchoBunpaishuyaku();
    }

    @Override
    public FlexibleDate get移行日() {
        return entity.getIkoYMD();
    }

    @Override
    public FlexibleDate get加入日() {
        return entity.getKanyuYMD();
    }

    @Override
    public FlexibleDate get離脱日() {
        return entity.getRidatsuYMD();
    }

    @Override
    public RString get合併旧市町村区分() {
        return entity.getGappeiKyuShichosonKubun();
    }

    @Override
    public RString get合併旧市町村表示有無() {
        return entity.getGappeiKyuShichosonHyojiUmu();
    }

    @Override
    public RString get合併情報地域番号() {
        return entity.getGappeiChiikiNo();
    }

    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return entity.getUnyoHokenshaNo();
    }

    @Override
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    @Override
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    @Override
    public RString get運用形態区分() {
        return entity.getUnyoKeitaiKubun();
    }

}
