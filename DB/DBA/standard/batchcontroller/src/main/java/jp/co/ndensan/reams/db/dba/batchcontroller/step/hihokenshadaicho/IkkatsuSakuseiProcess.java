/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.IkkatsuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshadaicho.IkkatsuSusakuseiProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.HihokenshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dba.service.hihokenshadaichosakusei.HihokenshaDaichoSakuseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿_バッチフ処理クラスです
 */
public class IkkatsuSakuseiProcess extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IIkkatsuSakuseiMapper.get被保険者台帳管理");
    private static final RString TITLE = new RString("介護保険　被保険者台帳");
    private static final RString HIHOKENSHANOTITLE = new RString("被保険者番号");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_03 = new RString("03");
    private static final RString SHIKAKUSOSHITSUJIYUCODE_05 = new RString("05");
    private static final RString STATE_適用除外者 = new RString("適用除外者");
    private static final RString STATE_他市町村住所地特例者 = new RString("他市町村住所地特例者");
    private static final RString STATE_資格取得者 = new RString("資格取得者");
    private static final RString STATE_資格喪失者 = new RString("資格喪失者");
    private static final RString SOCHIHOKENSHATITLE = new RString("措置保険者");
    private static final RString KYUHOKENSHATITLE = new RString("旧保険者");
    private static final RString JUSHO_TITLE = new RString("住所");
    private static final RString GYOSEIKU_TITLE = new RString("行政区");
    private static final Code SHICHOSONCODE_120 = new Code("120");
    private static final Code SHICHOSONCODE_220 = new Code("220");
    private static final Code SHICHOSONCODE_111 = new Code("111");
    private static final Code SHICHOSONCODE_112 = new Code("112");
    private static final Code SHICHOSONCODE_211 = new Code("211");
    private static final RString NYUSHOSHISETSUSHURUI_11 = new RString("11");
    private IkkatsuSusakuseiProcessParameter processPrm;
    private IkkatsuSakuseiMybatisParameter mybatisPrm;
    private IIkkatsuSakuseiMapper iIkkatsuSakuseiMapper;
    private List<HihokenshaEntity> 被保険者EntityList;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuSakuseiMapper = getMapper(IIkkatsuSakuseiMapper.class);
        被保険者EntityList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toIkkatsuHakkoMybatisParameter());
    }

    @Override
    protected void createWriter() {

    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        被保険者EntityList.add(set被保険者Entity(entity));
    }

    @Override
    protected void afterExecute() {
        sort帳票データ();
        HihokenshaDaichoSakuseiManager.createInstance().getHihokenshaDaichoHenshu(被保険者EntityList);
        if (processPrm.getShutsuryokuFlag().toString().equals("1")) {
            /**
             * TODO 段站立 被保険者台帳一覧クラス実装しない
             */
        }

    }

    /**
     * TODO 段站立 帳票出力順IDから出力順の取得を確認
     */
    private void sort帳票データ() {
        get帳票データ();
    }

    private void get帳票データ() {
        for (HihokenshaEntity hihokenshaEntity : 被保険者EntityList) {
            IkkatsuSakuseiMybatisParameter mybatisPram = createParm(hihokenshaEntity);
            hihokenshaEntity.setDbT1001HihokenshaDaichoEntityList(iIkkatsuSakuseiMapper.get被保険者台帳管理(mybatisPram));
            hihokenshaEntity.setShisetsuNyutaishoEntityList(iIkkatsuSakuseiMapper.get生活保護受給者(mybatisPram));
            hihokenshaEntity.setDbT7006RoreiFukushiNenkinJukyushaEntityList(iIkkatsuSakuseiMapper.get老齢福祉年金受給者(mybatisPram));
            hihokenshaEntity.setDbT7037ShoKofuKaishuEntityList(iIkkatsuSakuseiMapper.get証交付回収(mybatisPram));
        }
    }

    private IkkatsuSakuseiMybatisParameter createParm(HihokenshaEntity entity) {
        IkkatsuSakuseiMybatisParameter pram = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(mybatisPrm.getChushutsuFlag(), mybatisPrm.getShichosonCode(), entity.getShikibetsuCode(),
                        mybatisPrm.getPsmShikibetsuTaisho());
        return pram;
    }

    private HihokenshaEntity set被保険者Entity(DbT1001HihokenshaDaichoEntity entity) {
        HihokenshaEntity 被保険者Entity = new HihokenshaEntity();
        被保険者Entity.setPrintDate(new RString(RDate.getNowDate().toString()));
        被保険者Entity.setPage(RString.EMPTY);
        被保険者Entity.setTitle(TITLE);
        被保険者Entity.setShichosonCode(entity.getShichosonCode());
        被保険者Entity.setShichosonMeisho(get市町村名称());
        被保険者Entity.setHihokenshaNoTitle(HIHOKENSHANOTITLE);
        被保険者Entity.setHihokenshaNo(entity.getHihokenshaNo());
        UaFt200FindShikibetsuTaishoEntity 識別対象Entity = get宛名識別対象取得(entity);
        IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(識別対象Entity);
        被保険者Entity.setKanaMeisho(shikibetsuTaisho.get名称().getKana());
        被保険者Entity.setMeisho(shikibetsuTaisho.get名称().getName());
        被保険者Entity.setSeinengappiYMD(shikibetsuTaisho.to個人().get生年月日().toFlexibleDate());
        被保険者Entity.setSeibetsuCode(shikibetsuTaisho.to個人().get性別().getCode());
        被保険者Entity.setSetaiCode(shikibetsuTaisho.to個人().get世帯コード());
        被保険者Entity.setShikibetsuCode(shikibetsuTaisho.to個人().get識別コード());
        被保険者Entity.setChikucodeTitle1(shikibetsuTaisho.to個人().get行政区画().getChiku1().get名称());
        被保険者Entity.setChikuCode1(shikibetsuTaisho.to個人().get行政区画().getChiku1().getコード());
        被保険者Entity.setChikucodeTitle2(shikibetsuTaisho.to個人().get行政区画().getChiku2().get名称());
        被保険者Entity.setChikuCode2(shikibetsuTaisho.to個人().get行政区画().getChiku2().getコード());
        被保険者Entity.setChikucodeTitle3(shikibetsuTaisho.to個人().get行政区画().getChiku3().get名称());
        被保険者Entity.setChikuCode3(shikibetsuTaisho.to個人().get行政区画().getChiku3().getコード());
        被保険者Entity.setJushoTitle(JUSHO_TITLE);
        被保険者Entity.setJusho(new RString(shikibetsuTaisho.get住所().toString()));
        被保険者Entity.setZenkokuJushoCode(shikibetsuTaisho.to個人().get住所().get全国住所コード());
        被保険者Entity.setGyoseikuTitle(GYOSEIKU_TITLE);
        被保険者Entity.setGyoseikuCode(shikibetsuTaisho.to個人().get行政区画().getGyoseiku().getコード());
        被保険者Entity.setTelephoneNo1(shikibetsuTaisho.to個人().get連絡先１().value());
        被保険者Entity.setTelephoneNo2(shikibetsuTaisho.to個人().get連絡先２().value());
        被保険者Entity.setSochiHokenshaTitle(SOCHIHOKENSHATITLE);
        被保険者Entity.setKyuHokenshaTitle(KYUHOKENSHATITLE);
        被保険者Entity.setState(get状態(entity));
        if (get入所施設(entity) != null) {
            被保険者Entity.setJigyoshaNo(get入所施設(entity).getJigyoshaNo());
            被保険者Entity.setJigyoshaMeisho(new AtenaMeisho(get入所施設(entity).getJigyoshaMeisho()));
        }
        if (get医療保険(entity) != null) {
            被保険者Entity.setIryoHokenShubetsu(get医療保険(entity).getIryoHokenShubetsuCode());
            被保険者Entity.setIryoHokenshaMeisho(get医療保険(entity).getIryoHokenshaMeisho());
            被保険者Entity.setIryoHokenKigoNo(get医療保険(entity).getIryoHokenKigoNo());
        }
        return 被保険者Entity;
    }

    private RString get市町村名称() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString shichosonMeisho = RString.EMPTY;
        Code 導入形態コード = shichosonSecurityJoho.get導入形態コード();
        if (導入形態コード.equals(SHICHOSONCODE_120) || 導入形態コード.equals(SHICHOSONCODE_220)) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            shichosonMeisho = association.get市町村名();
        }
        if (導入形態コード.equals(SHICHOSONCODE_111) || 導入形態コード.equals(SHICHOSONCODE_112)
                || 導入形態コード.equals(SHICHOSONCODE_211)) {
            shichosonMeisho = iIkkatsuSakuseiMapper.get市町村名称(mybatisPrm).getShichosonMeisho();
        }
        return shichosonMeisho;
    }

    private RString get状態(DbT1001HihokenshaDaichoEntity entity) {
        RString 資格喪失事由コード = entity.getShikakuSoshitsuJiyuCode();
        RString state = RString.EMPTY;
        if (SHIKAKUSOSHITSUJIYUCODE_03.equals(資格喪失事由コード)) {
            state = STATE_適用除外者;
        } else if (SHIKAKUSOSHITSUJIYUCODE_05.equals(資格喪失事由コード)) {
            state = STATE_他市町村住所地特例者;
        } else if (RString.EMPTY.equals(資格喪失事由コード)) {
            state = STATE_資格取得者;
        } else {
            state = STATE_資格喪失者;
        }
        return state;
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名識別対象取得(DbT1001HihokenshaDaichoEntity entity) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.set識別コード(entity.getShikibetsuCode());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString();
        IkkatsuSakuseiMybatisParameter pram = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(mybatisPrm.getChushutsuFlag(), mybatisPrm.getShichosonCode(), mybatisPrm.getShikibetsuCode(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));

        return iIkkatsuSakuseiMapper.get識別対象(pram);
    }

    private ShisetsuNyutaishoEntity get入所施設(DbT1001HihokenshaDaichoEntity entity) {
        IkkatsuSakuseiMybatisParameter pram = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(mybatisPrm.getChushutsuFlag(), mybatisPrm.getShichosonCode(), entity.getShikibetsuCode(),
                        mybatisPrm.getPsmShikibetsuTaisho());
        ShisetsuNyutaishoEntity 入所施設Entity = iIkkatsuSakuseiMapper.get入所施設(pram);
        if (入所施設Entity != null && NYUSHOSHISETSUSHURUI_11.equals(入所施設Entity.getNyushoShisetsuShurui())) {
            入所施設Entity.setJigyoshaMeisho(new RString(入所施設Entity.getJigyoshaName().toString()));
        }
        return 入所施設Entity;
    }

    private DbT1008IryohokenKanyuJokyoEntity get医療保険(DbT1001HihokenshaDaichoEntity entity) {
        IkkatsuSakuseiMybatisParameter pram = IkkatsuSakuseiMybatisParameter.
                createSelectByKeyParam(mybatisPrm.getChushutsuFlag(), mybatisPrm.getShichosonCode(), entity.getShikibetsuCode(),
                        mybatisPrm.getPsmShikibetsuTaisho());
        return iIkkatsuSakuseiMapper.get介護保険医療保険加入状況(pram);
    }

}
