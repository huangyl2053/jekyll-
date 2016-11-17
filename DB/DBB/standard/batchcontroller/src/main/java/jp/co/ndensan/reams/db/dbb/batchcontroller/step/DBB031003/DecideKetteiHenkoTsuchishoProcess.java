/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.KetteiHenkoTsuchishoUchiwakeShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.TmpHonsanteiTsuchishoTableEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定変更通知書出力判定するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class DecideKetteiHenkoTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper.select本算定通知書all");

    private static final int INT_1 = 1;
    private static final RString 対象者_全て = new RString("2");
    private static final RString 対象者_口座 = new RString("1");
    private static final RString 対象者_現金 = new RString("0");
    private static final RString 口座区分_現金納付 = new RString("0");
    private static final RString 口座区分_口座振替 = new RString("1");
    private static final RString 本算定通知書一時テーブル = new RString("TmpHonsanteiTsuchisho");
    private IHonsanteiTsuchishoIkkatsuHakkoMapper mapper;
    private HonsanteiTsuchishoIkkatsuHakkoSyori honsanteiSyori;
    private HonsanteiTsuchishoIkkatsuHakko manager;
    private HonsanteifukaProcessParameter processParameter;
    private static final RString キー_打分け条件 = new RString("打分け条件");
    private static final RString キー_賦課処理区分 = new RString("賦課処理区分");
    private DbT2014TsuchishoUchiwakeJokenEntity 通知書打ち分け条件情報;

    private int 仮算定最終期;
    private int 仮算定最初期;
    private int 本算定最終期;
    private int 本算定最初期;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 本算定通知書一時テーブルtableWriter;

    @Override
    protected void initialize() {

        manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        honsanteiSyori = new HonsanteiTsuchishoIkkatsuHakkoSyori();
        mapper = getMapper(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_打分け条件.toString(), processParameter.get打分け条件情報());
        parameter.put(キー_賦課処理区分.toString(), KetteiHenkoTsuchishoUchiwakeShoriKubun.本算定賦課.getコード());
        通知書打ち分け条件情報 = mapper.select通知書打ち分け条件情報(parameter);

        initialize月期対応取得_普徴();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        本算定通知書一時テーブルtableWriter
                = new BatchEntityCreatedTempTableWriter(本算定通知書一時テーブル, TmpHonsanteiTsuchishoTableEntity.class);
    }

    @Override
    protected void process(HonsanteiTsuchishoTempEntity tempEntity) {

        if (通知書打ち分け条件情報 == null) {
            return;
        }
        HonsanteiTsuchishoTempResult tmpResult = new HonsanteiTsuchishoTempResult();
        try {
            tmpResult = manager.get賦課情報(tempEntity);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DecideKetteiHenkoTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        int 選択通知書No = manager.get選択通知書No(仮算定最初期, 仮算定最終期, 本算定最初期, 本算定最終期, tmpResult);
        if (選択通知書No == 0) {
            return;
        }
        RString 選択現金口座 = manager.get選択現金口座(通知書打ち分け条件情報, 選択通知書No);
        FukaJoho 賦課の情報_更正後 = tmpResult.get賦課の情報_更正後().get賦課情報();
        if (対象者_全て.equals(選択現金口座)
                || (対象者_口座.equals(選択現金口座) && 口座区分_口座振替.equals(賦課の情報_更正後.get口座区分()))
                || (対象者_現金.equals(選択現金口座) && 口座区分_現金納付.equals(賦課の情報_更正後.get口座区分()))) {
            RString 選択通知書 = manager.get選択通知書(通知書打ち分け条件情報, 選択通知書No);
            RString 出力順グループ名 = manager.get出力順グループ名(通知書打ち分け条件情報, 選択通知書No);

            本算定通知書一時テーブルtableWriter.update(honsanteiSyori.to賦課情報_決定変更判定(tempEntity, 選択通知書, 出力順グループ名));
        }
    }

    @Override
    protected void afterExecute() {

    }

    private void initialize月期対応取得_普徴() {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        仮算定最終期 = 仮算定期間.getLast().get期AsInt();
        if (仮算定最終期 == 0) {
            仮算定最初期 = 0;
        } else {
            List<Kitsuki> 仮算定期間List = 仮算定期間.toList();
            仮算定最初期 = 仮算定期間List.get(仮算定期間List.size() - INT_1).get期AsInt();
        }
        本算定最終期 = 本算定期間.getLast().get期AsInt();
        List<Kitsuki> 本算定期間List = 本算定期間.toList();
        本算定最初期 = 本算定期間List.get(本算定期間List.size() - INT_1).get期AsInt();
    }
}
